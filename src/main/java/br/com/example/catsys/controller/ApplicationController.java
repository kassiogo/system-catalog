package br.com.example.catsys.controller;

import br.com.example.catsys.dto.application.ApplicationDTO;
import br.com.example.catsys.model.Application;
import br.com.example.catsys.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationDTO create(@RequestBody ApplicationDTO dto) {
        var application = mapper.map(dto, Application.class);
        application = applicationService.save(application);
        return mapper.map(application, ApplicationDTO.class);
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> findAllApplications() {
        var dtos = applicationService.findAll().stream()
            .map(application -> mapper.map(application, ApplicationDTO.class))
            .toList();
        return ResponseEntity.ok(dtos);
    }
}
