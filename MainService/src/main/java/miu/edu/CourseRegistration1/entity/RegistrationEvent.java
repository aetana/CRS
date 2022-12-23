package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RegistrationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    //2022-12-22 12:30
    private LocalDateTime startDate;
    private  LocalDateTime endDate;

    //private boolean status;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn
    private List<RegistrationGroup>registrationGroups;

}
