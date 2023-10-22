package br.com.example.catsys.dto.application;

import br.com.example.catsys.dto.BaseDTO;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
public class ApplicationDTO extends BaseDTO {
    private String name;
    private String abbreviationCode;
    private String description;
    private String sourceCodeLocationUrl;
}
