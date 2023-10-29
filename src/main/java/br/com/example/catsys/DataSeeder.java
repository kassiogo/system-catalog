package br.com.example.catsys;

import java.util.HashSet;
import java.util.Set;

import br.com.example.catsys.enums.TechnologyTypeEnum;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.example.catsys.model.Application;
import br.com.example.catsys.model.Technology;
import br.com.example.catsys.repository.ApplicationRepository;
import br.com.example.catsys.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {
    
    private final ApplicationRepository applicationRepository;
    private final TechnologyRepository technologyRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Technology technology1 = new Technology();
        technology1.setName("JAVA");
        technology1.setDescription("LINGUAGEM DE PROGRAMAÇÃO JAVA");
        technology1.setTechnologyType(TechnologyTypeEnum.PROGRAM_LANGUAGE);
        
        Technology technology2 = new Technology();
        technology2.setName("NODEJS");
        technology2.setDescription("LINGUAGEM DE PROGRAMAÇÃO JAVASCRIPT");
        technology2.setTechnologyType(TechnologyTypeEnum.PROGRAM_LANGUAGE);

        var createdTechnology1 = technologyRepository.save(technology1);
        var createdTechnology2 = technologyRepository.save(technology2);

        Set<Technology> technologies = new HashSet<>();
        technologies.add(createdTechnology1);
        technologies.add(createdTechnology2);
        
        Application application = new Application();
        application.setName("SYSTEM CATALOG");
        application.setAbbreviationCode("SYSCAT");
        application.setDescription("CATALOG OF SYSTEMS");
        application.setSourceCodeLocationUrl("https://github.com/catsys");
        application.setTechnologies(technologies);

        Application createdApplication = applicationRepository.save(application);

        createdApplication.getTechnologies().forEach(System.out::println);
    }
}
