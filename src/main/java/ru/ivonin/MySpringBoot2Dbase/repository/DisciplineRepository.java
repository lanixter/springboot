package ru.ivonin.MySpringBoot2Dbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivonin.MySpringBoot2Dbase.entity.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
