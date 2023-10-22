package br.com.example.catsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.example.catsys.model.Application;
import br.com.example.catsys.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public Optional<Application> findById(Long id) {
        return applicationRepository.findById(id);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }
}
