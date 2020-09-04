package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAllByCourse(Long id);
}
