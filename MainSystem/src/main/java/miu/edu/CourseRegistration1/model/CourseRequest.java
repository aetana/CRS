package miu.edu.CourseRegistration1.model;

import lombok.Data;

@Data
public class CourseRequest {
    private  int priority;
    private String course_code;//should be course offering code
    private Long reg_event_id;

}
