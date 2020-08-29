package ua.knu.sc_teacher.dto;

import lombok.Getter;
import ua.knu.sc_teacher.model.Course;

import java.time.LocalDate;

@Getter
public class CoursePreviewDto {
    private final Long id;
    private final String label;
    private final String comment;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public CoursePreviewDto(Course course) {
        this.id = course.getId();
        this.label = course.getTitle();
        this.comment = course.getComment();
        this.startDate = course.getStartDate();
        this.endDate = course.getEndDate();
    }
}
