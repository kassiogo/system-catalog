package br.com.example.catsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.catsys.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    
}
