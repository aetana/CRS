package miu.edu.CourseRegistration1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String courseCode;
    private int capacity;
    private int numberOfRegisteredStudents;
    private int availableSeats;
    private String initials;

    @ManyToOne
    private Course course;
    @ManyToOne
    private Faculty faculty;
    @OneToMany
    private List<RegistrationRequest> registrationRequestList;




//    public void setCourseCode(Course c, AcademicBlock ab, Faculty f) {
//        this.courseCode = c.getCode() + " " + ab.getCode() + f.getFirstName().substring(0, 1).toUpperCase() + " " +
//                f.getLastName().substring(0, 1).toUpperCase();
//    }
//}


}
