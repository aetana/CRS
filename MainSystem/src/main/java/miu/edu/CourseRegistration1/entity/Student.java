package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student extends Person{

    private long studentID;
    @ManyToOne
    private Address mailingAddress;
    @ManyToOne
    private Address homeAddress;
    @OneToMany(mappedBy = "student")
    private List<RegistrationRequest> registrationRequests;

    public Student(String firstName, String lastName, String email, long studentID,String username, String password, Address mailingAddress) {
        super(firstName, lastName, email, new User(username, password, Role.STUDENT));
        this.studentID = studentID;
        this.mailingAddress = mailingAddress;

    }
}
