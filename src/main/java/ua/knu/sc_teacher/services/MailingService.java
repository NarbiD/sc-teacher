package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.model.Mailing;

import java.util.List;

public interface MailingService {
    List<Mailing> findAllByCourse(Long id);
}
