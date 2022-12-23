package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private String code; //e.g CS544

    @ManyToMany
    @JoinTable(name = "prerequisite")
    private List<Course> prerequisite;

    public Course(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }
}
