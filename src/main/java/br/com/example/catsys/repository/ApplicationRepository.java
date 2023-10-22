package br.com.example.catsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.catsys.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
}
