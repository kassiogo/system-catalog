package br.com.example.catsys.model;

import br.com.example.catsys.enums.TechnologyTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "technologies")
public class Technology extends BaseEntity {
	@Column(nullable = false, length = 250)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TechnologyTypeEnum technologyType;

    /*
    @ManyToMany(mappedBy = "technologies")
    @JsonIgnore
    @ToString.Exclude
    private Set<Application> applications;

     */
}
