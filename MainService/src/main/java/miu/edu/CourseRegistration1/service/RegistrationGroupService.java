package miu.edu.CourseRegistration1.service;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationGroup;
import miu.edu.CourseRegistration1.repository.RegistrationGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegistrationGroupService {

    List<RegistrationGroup> findRegistrationGroups();
}
