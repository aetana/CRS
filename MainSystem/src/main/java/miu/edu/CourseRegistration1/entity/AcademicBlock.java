package miu.edu.CourseRegistration1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
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
    private String name; //eg. December 2022
    private String semester; //eg. Spring Summer Winter
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="academic_block_id")
    private List<CourseOffering> courseOffering;

    public AcademicBlock(String code, String name, String semester, LocalDate startDate, LocalDate endDate) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
