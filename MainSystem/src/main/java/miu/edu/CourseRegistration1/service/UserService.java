package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.User;

public interface UserService {
    void addUser(User u);
    void deleteUserById(Long id);

}