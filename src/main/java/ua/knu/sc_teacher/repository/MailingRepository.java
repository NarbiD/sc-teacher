package ua.knu.sc_teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.knu.sc_teacher.model.Mailing;

import java.util.List;

public interface MailingRepository extends JpaRepository<Mailing, Long> {
    List<Mailing> findAllByCourse_Id(Long id);
}
