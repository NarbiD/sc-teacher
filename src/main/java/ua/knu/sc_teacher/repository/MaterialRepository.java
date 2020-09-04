package ua.knu.sc_teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.knu.sc_teacher.model.Material;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findAllByCourse_Id(Long id);

}
