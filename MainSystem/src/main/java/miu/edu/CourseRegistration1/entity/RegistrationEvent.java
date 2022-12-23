package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
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
    private LocalDate startDate;
    private  LocalDate endDate;

    //private boolean status;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "registration_event_id")
    private List<RegistrationGroup> registrationGroups;


    public RegistrationEvent(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
