package br.com.example.catsys.service;

import org.springframework.stereotype.Service;

import br.com.example.catsys.model.Technology;
import br.com.example.catsys.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechnologyService {
    private final TechnologyRepository technologyRepository;

    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }
}
