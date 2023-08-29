package marc.dev.studentservice.controller;

import lombok.RequiredArgsConstructor;
import marc.dev.studentservice.entities.Student;
import marc.dev.studentservice.services.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getFirstname());
        return  new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return  new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findSchoolStudents(@PathVariable("schoolId") Long schoolId) {
        return  new ResponseEntity<>(studentService.findAllStudentsBySchool(schoolId), HttpStatus.OK);
    }
}
