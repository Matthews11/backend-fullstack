package com.mitocode.controller;

import com.mitocode.dto.ConsultDTO;
import com.mitocode.dto.ConsultListExamDTO;
import com.mitocode.model.Consult;
import com.mitocode.model.Exam;
import com.mitocode.service.IConsultService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consults")
@RequiredArgsConstructor
public class ConsultController {

    private final IConsultService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ConsultDTO>> findAll() {
        List<ConsultDTO> list = mapperUtil.mapList(service.findAll(), ConsultDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultDTO> findById(@PathVariable("id") Integer id) {
        Consult obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, ConsultDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ConsultListExamDTO dto) {
        Consult obj = service.saveTransactional(mapperUtil.map(dto.getConsult(), Consult.class) , mapperUtil.mapList(dto.getLstExam(), Exam.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsult()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ConsultDTO dto) {
        dto.setIdConsult(id);
        Consult obj = service.update(id, mapperUtil.map(dto, Consult.class));

        return ResponseEntity.ok(mapperUtil.map(obj, ConsultDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
