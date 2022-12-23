package miu.edu.CourseRegistration1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String courseCode; //eg. CS544-2022-12A-12D-XX
    private int capacity;
    private int numberOfRegisteredStudents;
    private int availableSeats;
    private String initials;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    @ManyToOne
    private Faculty faculty;

    @OneToMany(mappedBy = "courseOffering")
    private List<RegistrationRequest> registrationRequests;

    public CourseOffering(String courseCode, int capacity, int numberOfRegisteredStudents, int availableSeats, String initials) {
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.numberOfRegisteredStudents = numberOfRegisteredStudents;
        this.availableSeats = availableSeats;
        this.initials = initials;
    }

    //    public void setCourseCode(Course c, AcademicBlock ab, Faculty f) {
//        this.courseCode = c.getCode() + " " + ab.getCode() + f.getFirstName().substring(0, 1).toUpperCase() + " " +
//                f.getLastName().substring(0, 1).toUpperCase();
//    }
//}


}
