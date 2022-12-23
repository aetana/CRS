package miu.edu.userService;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationEventModel {
    private String status;
    private Date startDate;
    private Date endDate;
}
