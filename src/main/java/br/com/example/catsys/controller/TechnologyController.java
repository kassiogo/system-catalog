package br.com.example.catsys.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.catsys.dto.technology.TechnologyDTO;
import br.com.example.catsys.model.Technology;
import br.com.example.catsys.service.TechnologyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("technologies")
public class TechnologyController {
    private final TechnologyService technologyService;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TechnologyDTO create(@RequestBody TechnologyDTO technologyDTO) {
        var technology = mapper.map(technologyDTO, Technology.class);
        technology = technologyService.save(technology);
        return mapper.map(technology, TechnologyDTO.class);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyDTO>> findAll() {
        var dtos = technologyService.findAll().stream()
            .map(technology -> mapper.map(technology, TechnologyDTO.class))
            .toList();
        return ResponseEntity.ok(dtos);
    }
}
