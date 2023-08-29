package marc.dev.schoolservice.services;

import lombok.RequiredArgsConstructor;
import marc.dev.schoolservice.client.StudentClient;
import marc.dev.schoolservice.entities.FullSchoolResponse;
import marc.dev.schoolservice.entities.School;
import marc.dev.schoolservice.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public School createSchool(School school){
        return schoolRepository.save(school);
    }
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public FullSchoolResponse getSchoolWithStudents(Long schoolId) {

        var school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                .name("Not Found")
                        .email("Not Found")
                        .build());

        var students = studentClient.findAllStudentsBySchoolId(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
