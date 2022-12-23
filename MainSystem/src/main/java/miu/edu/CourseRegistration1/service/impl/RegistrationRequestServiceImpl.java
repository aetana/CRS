package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.CourseOffering;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.entity.RegistrationRequest;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.model.RegistrationRequestModelList;
import miu.edu.CourseRegistration1.model.RegistrationRequestModel;
import miu.edu.CourseRegistration1.repository.CourseOfferingRepo;
import miu.edu.CourseRegistration1.repository.RegistrationRequestRepo;
import miu.edu.CourseRegistration1.security.AwesomeUserDetails;
import miu.edu.CourseRegistration1.service.RegistrationEventService;
import miu.edu.CourseRegistration1.service.RegistrationRequestService;
import miu.edu.CourseRegistration1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepo registrationRequestRepo;
    @Autowired
    private RegistrationEventService registrationEventService;

    @Autowired
    private CourseOfferingRepo courseOfferingRepo;


    public boolean isRegistrationEventOpen(long studentId){
        LocalDate today = LocalDate.now();
        System.out.println("registration request service "+studentId);
        RegistrationEvent currentEvent = registrationEventService.getLatestRegistrationEvent(studentId);
        LocalDate startDate = currentEvent.getStartDate();
        LocalDate endDate = currentEvent.getEndDate();
        if(today.isAfter(startDate) && today.isBefore(endDate))
            return true;
        else return false;
    }
    @Override
    public void createRegistrationRequest (RegistrationRequestModelList registrationRequestModelList, Student student) throws Exception{
        if(student==null) {
            throw new Exception("Student is Not Found!");
        }
        if(isRegistrationEventOpen(student.getStudentID())) {
            List<RegistrationRequest> registrationRequests = new ArrayList<>();
            for(RegistrationRequestModel registrationRequestModel: registrationRequestModelList.getRegistrationRequestModels()){
//      Set student to each registration request
                registrationRequestModel.getRegistrationRequest().setStudent(student);
                CourseOffering courseOffering = courseOfferingRepo.findByCourseCode(registrationRequestModel.getCourseOfferingCode());

                if(courseOffering == null){
                    throw new Exception("CourseOffering Not found!");
                }
                registrationRequestModel.getRegistrationRequest().setCourseOffering(courseOffering);
                registrationRequests.add(registrationRequestModel.getRegistrationRequest());

            }
//      Validating that there is one RegistrationRequests per CourseOffering
            Set<RegistrationRequest> uniqueList = registrationRequests
                    .stream() // get stream for original list
                    .distinct()
                    .collect(Collectors.toCollection(//distinct elements stored into new SET
                            () -> new TreeSet<>(Comparator.comparing( req -> req.getCourseOffering().getCourseCode())))
                    );
            registrationRequestRepo.saveAll(uniqueList);
        }
        else throw new Exception("RegistrationEvent is Not Opened yet or Closed");
    }
}
