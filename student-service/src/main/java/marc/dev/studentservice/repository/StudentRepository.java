package marc.dev.studentservice.repository;

import marc.dev.studentservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllStudentBySchoolId(Long schoolId);
}
