package br.com.example.catsys.dto.application;

import java.util.Set;

import br.com.example.catsys.dto.BaseDTO;
import br.com.example.catsys.dto.technology.TechnologyDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ApplicationDTO extends BaseDTO {
    private String name;
    private String abbreviationCode;
    private String description;
    private String sourceCodeLocationUrl;
    private Set<TechnologyDTO> technologies;
}
