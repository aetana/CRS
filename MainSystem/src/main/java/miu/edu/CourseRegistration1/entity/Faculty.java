package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Faculty extends Person{
    private Long facultyId;
    private String title;

    public Faculty(String firstName,String lastName,String email, String username, String password) {
        super(firstName, lastName, email, new User(username, password, Role.FACULTY));
    }
}
