package ru.ivonin.MySpringBoot2Dbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivonin.MySpringBoot2Dbase.dao.DisciplineDAO;
import ru.ivonin.MySpringBoot2Dbase.entity.Discipline;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public void saveDiscipline(Discipline discipline) {
        disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    public Discipline getDiscipline(Long id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(Long id) {
        disciplineDAO.deleteDiscipline(id);
    }

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }
}
