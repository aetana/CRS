package miu.edu.CourseRegistration1.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class RegistrationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    //private String regGroup;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "registrationgroup_id")
    private List<AcademicBlock> academicBlocks;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;




}
