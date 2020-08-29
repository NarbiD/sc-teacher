package ua.knu.sc_teacher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String comment;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "course")
    private List<Task> tasks;

    @OneToMany(mappedBy = "course")
    private List<Mailing> mailings;

    @OneToMany(mappedBy = "course")
    private List<Material> material;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Student> students;

}
