package marc.dev.studentservice.services;

import lombok.RequiredArgsConstructor;
import marc.dev.studentservice.entities.Student;
import marc.dev.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student saveStudent(Student student){

        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return  studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Long schoolId) {
        return studentRepository.findAllStudentBySchoolId(schoolId);
    }
}
