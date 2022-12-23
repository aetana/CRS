package miu.edu.CourseRegistration1.kafka;

import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.entity.RegistrationGroup;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.service.impl.RegistrationEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EmailScheduler {

    @Autowired
    private RegistrationEventServiceImpl registrationEventService;
    @Autowired
    private Publisher publisher;

   //cron task that runs twice every day and checks if reminder should be sent for any registration event
    //run a task every day at 12:00 AM (midnight), "run at the 0th minute of the 0th hour every day".
    @Scheduled(cron = "0 16,20 0 * * *")
    public void runTaskBasedOnRegistrationEndDate() {
        List<RegistrationEvent> registrationEvents = registrationEventService.findAll();
        for(RegistrationEvent registrationEvent: registrationEvents){
            LocalDate endDate = registrationEvent.getEndDate();
            if(endDate.isEqual(LocalDate.now())){
                for(RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroups()){
                    for(Student student: registrationGroup.getStudents()){
                        publisher.publishMessage("emailTopic", new EmailMessage(student.getEmail(),
                                "Please Complete your Registration its will Close soon.",
                                "Dear All Students,\n" +
                                        "\n" +
                                        "This is to remind you that the online registration system will open on Thursday, " +
                                        "\n " +
                                        "Sept 8th at 3:30 PM and it will close on Monday evening, Sept 12th at 10:00 PM. " +"\n " +
                                        "The URL of the registration web page is:  https://registrations.cs.miu.edu/authentication/login. " +"\n " +
                                        "Use your InfoSys login credentials to access the registration system. Make sure you save your " +"\n " +
                                        "selection before closing the registration system.\n" +
                                        "\n" +
                                        "Please note that MSCS students are now allowed to take any of the following MSD courses as part " + "\n " +
                                        "of the MSCS graduation requirements. We will also make the courses available through the registration system.\n"));
                    }
                }

            }
        }
    }

//    @Scheduled(cron = "0 */1 * ? * *")
//    public void runTaskBasedOnRegistrationEndDate() {
//        publisher.publishMessage("emailTopic",new EmailMessage(
//                "amanuel.etanan@gmail.com",
//                "Please Complete your Registration its will Close Soon.",
//                "Dear All Students,\n" +
//                        "\n" +
//                        "This is to remind you that the online registration system will open on Thursday, " +
//                        "\n " +
//                        "Sept 8th at 3:30 PM and it will close on Monday evening, Sept 12th at 10:00 PM. " +"\n " +
//                        "The URL of the registration web page is:  https://registrations.cs.miu.edu/authentication/login. " +"\n " +
//                        "Use your InfoSys login credentials to access the registration system. Make sure you save your " +"\n " +
//                        "selection before closing the registration system.\n" +
//                        "\n" +
//                        "Please note that MSCS students are now allowed to take any of the following MSD courses as part " + "\n " +
//                        "of the MSCS graduation requirements. We will also make the courses available through the registration system.\n"));
//    }
}
