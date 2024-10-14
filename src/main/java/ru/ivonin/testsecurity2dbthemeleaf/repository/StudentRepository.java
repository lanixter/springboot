package ru.ivonin.testsecurity2dbthemeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivonin.testsecurity2dbthemeleaf.repository.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
