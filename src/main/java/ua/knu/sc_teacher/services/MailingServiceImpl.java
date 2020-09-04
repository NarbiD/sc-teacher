package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Mailing;
import ua.knu.sc_teacher.repository.MailingRepository;

import java.util.List;

@Service
public class MailingServiceImpl implements MailingService {
    final MailingRepository mailingRepository;

    public MailingServiceImpl(MailingRepository mailingRepository) {
        this.mailingRepository = mailingRepository;
    }

    @Override
    public List<Mailing> findAllByCourse(Long id) {
        return mailingRepository.findAllByCourse_Id(id);
    }
}
