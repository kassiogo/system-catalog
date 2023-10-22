package br.com.example.catsys.dto.technology;

import br.com.example.catsys.dto.BaseDTO;
import br.com.example.catsys.enums.TechnologyTypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TechnologyDTO extends BaseDTO {
    private String name;
    private String description;
    private TechnologyTypeEnum technologyType;
}
