package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationGroup;
import miu.edu.CourseRegistration1.repository.RegistrationGroupRepo;
import miu.edu.CourseRegistration1.service.RegistrationGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RegistrationGroupImpl implements RegistrationGroupService {

    RegistrationGroupRepo registrationGroupRepo;
    @Override
    public List<RegistrationGroup> findRegistrationGroups() {

        return registrationGroupRepo.findAll();
    }
}
