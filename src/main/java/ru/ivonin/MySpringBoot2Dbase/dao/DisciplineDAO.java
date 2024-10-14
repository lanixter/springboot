package ru.ivonin.MySpringBoot2Dbase.dao;

import ru.ivonin.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

public interface DisciplineDAO {
    void saveDiscipline(Discipline discipline);
    Discipline getDiscipline(Long id);
    void deleteDiscipline(Long id);
    List<Discipline> getAllDisciplines();
}
