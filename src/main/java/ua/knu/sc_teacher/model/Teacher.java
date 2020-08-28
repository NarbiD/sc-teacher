package ua.knu.sc_teacher.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;
    String contacts;
    String status;
    String avatar;

    private String login;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "teacher")
    private List<Token> tokens;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    List<Course> course;
}
