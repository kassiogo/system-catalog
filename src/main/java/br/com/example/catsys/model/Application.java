package br.com.example.catsys.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Application that = (Application) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
