package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.knu.sc_teacher.model.Student;

@Getter
@AllArgsConstructor
public class StudentShortDto {
    private final Long id;
    private final String name;
    private final String nickname;

    public StudentShortDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.nickname = student.getNickname();
    }
}
