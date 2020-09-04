package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.knu.sc_teacher.model.Task;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TaskShortDto {
    private final Long id;

    private final String title;
    private final String comment;
    private final LocalDate startDate;
    private final LocalDate endDate;

    private final Long course;

    public TaskShortDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.comment = task.getComment();
        this.startDate = task.getStartDate();
        this.endDate = task.getEndDate();
        this.course = task.getCourse().getId();
    }
}
