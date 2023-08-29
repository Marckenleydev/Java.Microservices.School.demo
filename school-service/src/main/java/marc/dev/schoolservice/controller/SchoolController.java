package marc.dev.schoolservice.controller;

import lombok.RequiredArgsConstructor;
import marc.dev.schoolservice.entities.FullSchoolResponse;
import marc.dev.schoolservice.entities.School;
import marc.dev.schoolservice.services.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        return  new ResponseEntity<>(schoolService.createSchool(school), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return  new ResponseEntity<>(schoolService.getAllSchools(), HttpStatus.OK);
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> getSchoolWithStudent(@PathVariable Long schoolId) {
//        System.out.println(schoolId);
        return  new ResponseEntity<>(schoolService.getSchoolWithStudents(schoolId), HttpStatus.OK);
    }
}
