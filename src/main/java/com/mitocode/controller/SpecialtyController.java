package com.mitocode.controller;

import com.mitocode.dto.SpecialtyDTO;
import com.mitocode.model.Specialty;
import com.mitocode.service.ISpecialtyService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final ISpecialtyService service;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> findAll() {
        List<SpecialtyDTO> list = mapperUtil.mapList(service.findAll(), SpecialtyDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> findById(@PathVariable("id") Integer id) {
        Specialty obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, SpecialtyDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SpecialtyDTO dto) {
        Specialty obj = service.save(mapperUtil.map(dto, Specialty.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSpecialty()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SpecialtyDTO dto) {
        dto.setIdSpecialty(id);
        Specialty obj = service.update(id, mapperUtil.map(dto, Specialty.class));

        return ResponseEntity.ok(mapperUtil.map(obj, SpecialtyDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    /*private SpecialtyDTO convertToDto(Specialty obj) {
        return modelMapper.map(obj, SpecialtyDTO.class);
    }

    private Specialty convertToEntity(SpecialtyDTO dto) {
        return modelMapper.map(dto, Specialty.class);
    }*/

}
