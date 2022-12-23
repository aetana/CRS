package miu.edu.CourseRegistration1.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class RegistrationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    //private String regGroup;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn
    private List<AcademicBlock> academicBlockList;
    @ManyToMany
    @JoinColumn
    private List<Student>students;


}
