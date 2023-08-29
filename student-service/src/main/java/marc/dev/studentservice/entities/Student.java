package marc.dev.studentservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long schoolId;

}
