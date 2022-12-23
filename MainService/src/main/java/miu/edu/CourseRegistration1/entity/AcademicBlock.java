package miu.edu.CourseRegistration1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String code; //eg.(2022-12A-12D)
    private String name;
    private String semester;
    private Date startDate;
    private Date endDate;
    @OneToMany
    @JoinColumn(name="academic_block_id")
    private List<CourseOffering> courseOffering;


}
