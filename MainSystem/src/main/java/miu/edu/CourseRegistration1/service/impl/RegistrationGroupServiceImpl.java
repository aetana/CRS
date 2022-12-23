package miu.edu.CourseRegistration1.service.impl;

import miu.edu.CourseRegistration1.entity.RegistrationGroup;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.repository.RegistrationGroupRepo;
import miu.edu.CourseRegistration1.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationGroupServiceImpl implements RegistrationGroupService {

    @Autowired
    private RegistrationGroupRepo registrationGroupRepo;

    @Override
    public void save(RegistrationGroup registrationGroup) {
        registrationGroupRepo.save(registrationGroup);
    }

    @Override
    public void saveAll(List<RegistrationGroup> registrationGroups){
        registrationGroupRepo.saveAll(registrationGroups);
    }
}
