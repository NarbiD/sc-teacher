package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.knu.sc_teacher.model.Material;

@Getter
@AllArgsConstructor
public class MaterialShortDto {
    private final Long id;
    private final String title;
    private final String comment;
    private final String link;
    private final String type;

    private final Long course;

    public MaterialShortDto(Material material) {
        this.id = material.getId();
        this.title = material.getTitle();
        this.comment = material.getComment();
        this.link = material.getLink();
        this.type = material.getType();
        this.course = material.getCourse().getId();
    }
}
