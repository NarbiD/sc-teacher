package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.knu.sc_teacher.model.Token;

@Data
@AllArgsConstructor
public class TokenDto {
    private String value;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getValue());
    }
}
