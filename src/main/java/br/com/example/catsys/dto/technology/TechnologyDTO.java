package br.com.example.catsys.dto.technology;

import br.com.example.catsys.dto.BaseDTO;
import br.com.example.catsys.enums.TechnologyTypeEnum;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDTO extends BaseDTO {
    private String name;
    private String description;
    private TechnologyTypeEnum technologyType;
}
