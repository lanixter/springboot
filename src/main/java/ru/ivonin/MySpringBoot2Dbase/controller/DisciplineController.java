package ru.ivonin.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivonin.MySpringBoot2Dbase.entity.Discipline;
import ru.ivonin.MySpringBoot2Dbase.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @PostMapping
    public ResponseEntity<String> saveDiscipline(@RequestBody Discipline discipline) {
        try {
            disciplineService.saveDiscipline(discipline);
            return ResponseEntity.status(HttpStatus.CREATED).body("Discipline successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create discipline");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable Long id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline != null) {
            return ResponseEntity.ok(discipline);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable Long id) {
        try {
            disciplineService.deleteDiscipline(id);
            return ResponseEntity.ok("Discipline successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discipline not found");
        }
    }

    @PutMapping
    public ResponseEntity<String> updateDiscipline(@RequestBody Discipline discipline) {
        try {
            // Проверка на существование дисциплины
            if (disciplineService.getDiscipline(discipline.getId()) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discipline not found");
            }
            disciplineService.saveDiscipline(discipline);
            return ResponseEntity.ok("Discipline successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update discipline");
        }
    }


    @GetMapping
    public List<Discipline> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }
}
