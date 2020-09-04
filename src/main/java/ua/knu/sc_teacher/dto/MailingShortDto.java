package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.knu.sc_teacher.model.Mailing;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class MailingShortDto {
    private final Long id;

    private final String title;
    private final String comment;
    private final String startDate;
    private final String time;

    private final Long course;

    public MailingShortDto(Mailing mailing) {
        this.id = mailing.getId();
        this.title = mailing.getTitle();
        this.comment = mailing.getComment();
        this.startDate = mailing.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.time = mailing.getDate().format(DateTimeFormatter.ISO_TIME);
        this.course = mailing.getCourse().getId();
    }
}
