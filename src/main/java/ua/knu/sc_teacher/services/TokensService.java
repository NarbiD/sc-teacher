package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.model.Teacher;

public interface TokensService {

    Teacher findOneByValue(String token);
}
