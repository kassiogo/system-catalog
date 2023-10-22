package br.com.example.catsys.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
        technologyService.save(technology);
        return mapper.map(technology, TechnologyDTO.class);
    }
}
