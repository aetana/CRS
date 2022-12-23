package miu.edu.CourseRegistration1.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.entity.RegistrationGroup;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.model.RegistrationEventModel;
import miu.edu.CourseRegistration1.repository.RegistrationEventRepo;
import miu.edu.CourseRegistration1.service.RegistrationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    RegistrationEventRepo registrationEventRepo;

    //USE CASE 1
    @Override
    public RegistrationEventModel getLatestRegistrationEvent() {
        RegistrationEventModel res = new RegistrationEventModel();

        LocalDate today = LocalDate.now();
        RegistrationEvent regEvent = registrationEventRepo.findLatestEvent();

        res.setEndDate(regEvent.getEndDate());
        res.setStartDate(regEvent.getStartDate());

        if(regEvent!=null){
           LocalDate eventDate = regEvent.getEndDate().toLocalDate();
           int check = today.compareTo(eventDate);
          if(check < 0 ){
              res.setStatus("registration event in progress");
              return res;
          }else{
              res.setStatus("registration event closed");
              return res;
          }
        }
        res.setStatus("no registration event found");
        return null;

    }

    //USE CASE 3 CREATE
    @Override
    public void createRegistrationEvent(RegistrationEvent registrationEvent) {
        registrationEventRepo.save(registrationEvent);
    }

    //GET
    @Override
    public List<RegistrationEvent> findAll() {
        return (List<RegistrationEvent>) registrationEventRepo.findAll();
    }

    //GET
    @Override
    public  RegistrationEvent findById(Long id){
        return registrationEventRepo.findById(id).get();
    }

    //GET USING STUDENT ID
    @Override
    public List<RegistrationEvent> findByStudentId(Long id) {
        List<RegistrationEvent> events = findAll();

        List<RegistrationEvent> newEvents = events.stream().map(e -> {

            List<RegistrationGroup> eventRegGroup = e.getRegistrationGroups().stream()
                    .filter(registrationGroup -> {
                        List<Student> students = registrationGroup.getStudents().stream()
                                .filter(student -> student.getId() == id)
                                .collect(Collectors.toList());

                        if(!students.isEmpty()){
                            return true;
                        }
                        else{
                            return false;
                        }
                    })
                    .map(registrationGroup -> {
                        List<Student> newStudentList = new ArrayList<>();
                        registrationGroup.setStudents(newStudentList);
                        return  registrationGroup;
                    })
                    .collect(Collectors.toList());

            e.setRegistrationGroups(eventRegGroup);
            return e;
        }).collect(Collectors.toList());

        return newEvents;
    }
    // USE CASE #: CRUD OPERATIONS
    public void deleteById(Long id){
        registrationEventRepo.deleteById(id);
    }

    public String updateRegistrationEvent(RegistrationEvent event, Long id){
        RegistrationEvent dbEvent = registrationEventRepo.findById(id).orElseGet(null);
        dbEvent.setEndDate(event.getEndDate());
        dbEvent.setStartDate(event.getStartDate());
        registrationEventRepo.save(dbEvent);
        return "successfully updated event";
    }

}
