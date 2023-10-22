package br.com.example.catsys.modelmapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

import br.com.example.catsys.dto.application.ApplicationDTO;
import br.com.example.catsys.model.Application;

class ModelMapperUnitTest {
    
    private ModelMapper mapper;
    private ApplicationDTO applicationDTO;

    @BeforeEach
    void setup() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration()
            .setSkipNullEnabled(true)
            .setFieldAccessLevel(AccessLevel.PRIVATE);
            
        this.applicationDTO = new ApplicationDTO();
        this.applicationDTO.setName("Catalog of Systems");
        this.applicationDTO.setAbbreviationCode("syscat");
        this.applicationDTO.setDescription("This is a system's catalog");
        this.applicationDTO.setSourceCodeLocationUrl("https://site.com/repository.git");
    }


    @Test
    void givenSource_whenFullFilled_thenDestinationFullMapped() {
        var source = this.applicationDTO;
        var destination = this.mapper.map(source, Application.class);

        assertEquals(destination.getName(), source.getName());
        assertEquals(destination.getAbbreviationCode(), source.getAbbreviationCode());
        assertEquals(destination.getDescription(), source.getDescription());
        assertEquals(destination.getSourceCodeLocationUrl(), source.getSourceCodeLocationUrl());
    }

    
    @Test
    void givenSource_whenWithPropertyNull_thenDestinationPropertyNotMapped() {
        var source = this.applicationDTO;
        
        var destination = this.mapper.map(source, Application.class);
        assertEquals("Catalog of Systems", destination.getName());

        source.setName(null);
        this.mapper.map(source, destination);
        assertEquals("Catalog of Systems", destination.getName());
    }
}
