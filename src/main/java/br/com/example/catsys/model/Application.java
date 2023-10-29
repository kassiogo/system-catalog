package br.com.example.catsys.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "applications")
public class Application extends BaseEntityAudit {
	@Column(nullable = false, length = 300)
    private String name;

    @Column(nullable = false, length = 6)
    private String abbreviationCode;

    @Column(length = 600)
    private String description;

    @Column(length = 600)
    private String sourceCodeLocationUrl;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
        name = "application_technology",
        joinColumns  = @JoinColumn(name = "application_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id", referencedColumnName = "id"),
        foreignKey = @ForeignKey(name = "FK_ApplicationTechnology_Application"),
        inverseForeignKey = @ForeignKey(name = "FK_ApplicationTechnology_Technology"))
    private Set<Technology> technologies;

}
