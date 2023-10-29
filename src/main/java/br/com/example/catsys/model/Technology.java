package br.com.example.catsys.model;

import br.com.example.catsys.enums.TechnologyTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
