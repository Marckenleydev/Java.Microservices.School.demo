package marc.dev.schoolservice.client;

import marc.dev.schoolservice.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentClient {
    @GetMapping("/api/v1/students/school/{schoolId}")
    List<Student> findAllStudentsBySchoolId(@PathVariable("schoolId") Long schoolId);
}