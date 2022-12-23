package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.RegistrationGroup;

import java.util.List;

public interface RegistrationGroupService {
    void save(RegistrationGroup registrationGroup);
    void saveAll(List<RegistrationGroup> registrationGroups);
}
