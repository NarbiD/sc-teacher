package ua.knu.sc_teacher.controllers;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.sc_teacher.dto.MaterialShortDto;
import ua.knu.sc_teacher.services.MaterialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MaterialsController {

    final MaterialService materialService;

    public MaterialsController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/api/courses/{id}/materials")
    public List<MaterialShortDto> getTasks(@CookieValue("AuthToken") String token, @PathVariable Long id) {
        return materialService.findAllByCourse(id).stream()
                .map(MaterialShortDto::new)
                .collect(Collectors.toList());
    }
}