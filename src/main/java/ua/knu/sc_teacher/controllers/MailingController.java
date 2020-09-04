package ua.knu.sc_teacher.controllers;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.sc_teacher.dto.MailingShortDto;
import ua.knu.sc_teacher.services.MailingService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MailingController {

    final MailingService mailingService;

    public MailingController(MailingService mailingService) {
        this.mailingService = mailingService;
    }

    @GetMapping("/api/courses/{id}/mailings")
    public List<MailingShortDto> getTasks(@CookieValue("AuthToken") String token, @PathVariable Long id) {
        return mailingService.findAllByCourse(id).stream()
                .map(MailingShortDto::new)
                .collect(Collectors.toList());
    }
}