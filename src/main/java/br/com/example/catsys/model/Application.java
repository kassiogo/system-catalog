package br.com.example.catsys.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "applications")
@Data
@EqualsAndHashCode(callSuper = true)
public class Application extends BaseEntityAudit {
    @Column(nullable = false, length = 300)
    private String name;

    @Column(nullable = false, length = 6)
    private String abbreviationCode;

    @Column(length = 600)
    private String description;

    @Column(length = 600)
    private String sourceCodeLocationUrl;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "application_technology",
        joinColumns  = @JoinColumn(name = "application_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id"),
        foreignKey = @ForeignKey(name = "FK_ApplicationTechnology_Application"),
        inverseForeignKey = @ForeignKey(name = "FK_ApplicationTechnology_Technology"))
    private Set<Technology> technologies = new HashSet<>();
}
