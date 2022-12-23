package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.User;
import miu.edu.CourseRegistration1.repository.UserRepo;
import miu.edu.CourseRegistration1.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    @Override
    public void addUser(User u) {
        userRepo.save(u);
    }

    public void addAll(List<User> users){
        userRepo.saveAll(users);
    }

    @Override
    public void deleteUserById(Long studentId) {
        userRepo.deleteById(studentId);
    }

}