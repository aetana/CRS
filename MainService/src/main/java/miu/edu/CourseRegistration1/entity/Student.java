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
    @OneToMany
    private List<RegistrationRequest> registrationRequestList;
}
