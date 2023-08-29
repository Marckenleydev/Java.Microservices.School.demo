package marc.dev.schoolservice.repository;

import marc.dev.schoolservice.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
