package br.com.example.catsys.model;

import java.util.Set;

import br.com.example.catsys.enums.TechnologyTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "technologies")
@Data
@EqualsAndHashCode(callSuper = true)
public class Technology extends BaseEntity {
    @Column(nullable = false, length = 250)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TechnologyTypeEnum technologyType;

    @ManyToMany(mappedBy = "technologies")
    private Set<Application> applications;
}
