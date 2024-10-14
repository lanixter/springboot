package ru.ivonin.MySpringBoot2Dbase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.ivonin.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

@Repository
public class DisciplineDAOImpl implements DisciplineDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveDiscipline(Discipline discipline) {
        if (discipline.getId() == null) {
            entityManager.persist(discipline);
        } else {
            entityManager.merge(discipline);
        }
    }


    @Override
    public Discipline getDiscipline(Long id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public void deleteDiscipline(Long id) {
        Discipline discipline = entityManager.find(Discipline.class, id);
        if (discipline != null) {
            entityManager.remove(discipline);
        }
    }

    @Override
    public List<Discipline> getAllDisciplines() {
        return entityManager.createQuery("from Discipline", Discipline.class).getResultList();
    }
}
