package miu.edu.CourseRegistration1.model;

import lombok.*;
import miu.edu.CourseRegistration1.entity.RegistrationGroup;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEventModel {
    private String status;
    private LocalDateTime startDate;
    private  LocalDateTime endDate;
}
