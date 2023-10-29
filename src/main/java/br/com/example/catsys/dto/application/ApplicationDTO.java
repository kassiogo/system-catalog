package br.com.example.catsys.dto.application;

import br.com.example.catsys.dto.BaseDTO;
import br.com.example.catsys.dto.technology.TechnologyDTO;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO extends BaseDTO {
    private String name;
    private String abbreviationCode;
    private String description;
    private String sourceCodeLocationUrl;
    private Set<TechnologyDTO> technologies;
}
