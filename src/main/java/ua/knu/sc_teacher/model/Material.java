package ua.knu.sc_teacher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String comment;
    private String link;
    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "course")
    private Course course;

    @ManyToMany(mappedBy = "materials", cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Task> tasks;

    @ManyToMany(mappedBy = "materials",cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Mailing> mailings;
}
