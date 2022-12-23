package miu.edu.CourseRegistration1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Student student;
    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private CourseOffering courseOffering;
    private int priority;
   // private


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequest that = (RegistrationRequest) o;
        return priority == that.priority && Objects.equals(id, that.id) && Objects.equals(student, that.student) && Objects.equals(courseOffering, that.courseOffering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, courseOffering, priority);
    }
}
