package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Admin extends Person{
    public Admin(String firstName,String lastName,String email, String username, String password) {
        super(firstName, lastName, email, new User(username, password, Role.ADMIN));
    }
}
