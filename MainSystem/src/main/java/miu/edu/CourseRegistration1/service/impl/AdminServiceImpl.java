package miu.edu.CourseRegistration1.service.impl;

import miu.edu.CourseRegistration1.entity.Admin;
import miu.edu.CourseRegistration1.repository.AdminRepo;
import miu.edu.CourseRegistration1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public void add(Admin admin){
        adminRepo.save(admin);
    }
}
