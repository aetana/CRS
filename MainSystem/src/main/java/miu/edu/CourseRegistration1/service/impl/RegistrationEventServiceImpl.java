package miu.edu.CourseRegistration1.service.impl;

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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Service
@Transactional
public class RegistrationEventServiceImpl implements RegistrationEventService {

    @Autowired
    RegistrationEventRepo registrationEventRepo;

    public RegistrationEvent getLatestRegistrationEvent(long studentID) {
        List<RegistrationEvent> studentEvents = getAllRegistrationEventByStudentIdTest(studentID);

        if(studentEvents.isEmpty()) return null;
        studentEvents.sort((e1,e2) -> e2.getEndDate().compareTo(e1.getEndDate()));
        return studentEvents.get(0);
    }

    public List<RegistrationEvent> getAllRegistrationEventByStudentIdTest(long studentID){
        List<RegistrationEvent> events = registrationEventRepo.findAll();
        List<RegistrationEvent> studentEvents = new ArrayList<>();

        for(RegistrationEvent registrationEvent: events){
            for(RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroups()){
                for(Student student: registrationGroup.getStudents()){
                    if(student.getId() == studentID){
                        studentEvents.add(registrationEvent);
                    }
                }
                //registrationGroup.setStudents(List.of());
            }
            registrationEvent.setRegistrationGroups(List.of());
        }

        return studentEvents;
    }

    //GET USING STUDENT ID
//    @Override
//    public List<RegistrationEvent> findByStudentId(Long id) {
    public List<RegistrationEvent> getAllRegistrationEventByStudentId(long id){
        List<RegistrationEvent> events = findAll();
        List<RegistrationEvent> newEvents = events.stream()
                .map(rEvent -> {
                    rEvent.setRegistrationGroups(rEvent.getRegistrationGroups().stream()
                        .filter(registrationGroup -> {
                            return registrationGroup.getStudents().stream()
                                    .filter(student -> student.getId() == id).findAny().isPresent();
                        })
                        .map(registrationGroup -> {
                            List<Student> newStudentList = new ArrayList<>();
                            registrationGroup.setStudents(newStudentList);
                            return  registrationGroup;
                        }).collect(Collectors.toList()));
            return rEvent;
        }).collect(Collectors.toList());

//        List<RegistrationEvent> newEvents = events.stream().map(e -> {
//            List<RegistrationGroup> eventRegGroup = e.getRegistrationGroups().stream()
//                    .filter(registrationGroup -> {
//                        List<Student> students = registrationGroup.getStudents().stream()
//                                .filter(student -> student.getId() == id)
//                                .collect(Collectors.toList());
//                        if(!students.isEmpty()){  return true;  }
//                        else{ return false;   }
//                    })
//                    .map(registrationGroup -> {
//                        List<Student> newStudentList = new ArrayList<>();
//                        registrationGroup.setStudents(newStudentList);
//                        return  registrationGroup;
//                    }).collect(Collectors.toList());
//            e.setRegistrationGroups(eventRegGroup);
//            return e;
//        }).collect(Collectors.toList());

        return newEvents;
    }

    public String checkEventStatus(RegistrationEvent event){
        LocalDate today = LocalDate.now();
        if (event != null) {
            LocalDate eventDate = event.getEndDate();
            int check = today.compareTo(eventDate);
            if (check < 0) {
                return  "registration event in progress";
            } else {
                return "registration event closed";
            }
        } else {
            return "no registration event found";
        }
    }

    //USE CASE 1
//    @Override
//    public RegistrationEventModel getLatestRegistrationEvent() {
//        RegistrationEventModel res = new RegistrationEventModel();
//
//        LocalDate today = LocalDate.now();
//        RegistrationEvent regEvent = registrationEventRepo.findLatestEvent();
//        res.setEndDate(regEvent.getEndDate());
//        res.setStartDate(regEvent.getStartDate());
//
//        if(regEvent!=null){
//           LocalDate eventDate = regEvent.getEndDate();
//           int check = today.compareTo(eventDate);
//          if(check < 0 ){
//              res.setStatus("registration event in progress");
//              return res;
//          }else{
//              res.setStatus("registration event closed");
//              return res;
//          }
//        }
//        res.setStatus("no registration event found");
//        return null;
//
//    }

    //USE CASE 3 CREATE
    @Override
    public void createRegistrationEvent(RegistrationEvent registrationEvent) {
        registrationEventRepo.save(registrationEvent);
    }

    public void addAll(List<RegistrationEvent> registrationEvents) {
        registrationEventRepo.saveAll(registrationEvents);
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
