package com.mitocode.controller;

import com.mitocode.dto.ExamDTO;
import com.mitocode.model.Exam;
import com.mitocode.service.IExamService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {

    private final IExamService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ExamDTO>> findAll() {
        List<ExamDTO> list = mapperUtil.mapList(service.findAll(), ExamDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> findById(@PathVariable("id") Integer id) {
        Exam obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, ExamDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ExamDTO dto) {
        Exam obj = service.save(mapperUtil.map(dto, Exam.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExam()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ExamDTO dto) {
        dto.setIdExam(id);
        Exam obj = service.update(id, mapperUtil.map(dto, Exam.class));

        return ResponseEntity.ok(mapperUtil.map(obj, ExamDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
