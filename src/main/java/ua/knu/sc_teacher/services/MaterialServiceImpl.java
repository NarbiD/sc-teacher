package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Material;
import ua.knu.sc_teacher.repository.MaterialRepository;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    final
    MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> findAllByCourse(Long id) {
        return materialRepository.findAllByCourse_Id(id);
    }
}
