package ua.knu.sc_teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.knu.sc_teacher.model.Token;

@Getter
@AllArgsConstructor
public class TokenDto {
    private final String value;

    public static TokenDto of(Token token) {
        return new TokenDto(token.getValue());
    }
}
