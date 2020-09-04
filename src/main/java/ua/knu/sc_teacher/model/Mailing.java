package ua.knu.sc_teacher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String comment;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "course")
    private Course course;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "mailing_material",
            joinColumns = @JoinColumn(name = "mailing_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Material> materials;
}
