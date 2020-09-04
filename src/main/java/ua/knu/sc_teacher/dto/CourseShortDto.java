package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.knu.sc_teacher.model.Course;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CourseShortDto {
    private final Long id;
    private final String title;
    private final String comment;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public CourseShortDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.comment = course.getComment();
        this.startDate = course.getStartDate();
        this.endDate = course.getEndDate();
    }
}
