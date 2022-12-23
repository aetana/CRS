package miu.edu.userService.services;

import lombok.AllArgsConstructor;
import miu.edu.userService.Repository.UserRepo;
import miu.edu.userService.model.Users;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepo userRepo;


    public void addUser(Users u) {
        userRepo.save(u);
    }

    public void deleteUserById(Long studentId) {
        userRepo.deleteById(studentId);
    }

    @RabbitListener(queues = {"registrationEventQueue"})
    public void send(String m){
        Long id =Long.valueOf(m.split(" ")[1]);
        deleteUserById(id);
    }

    public Users getUserByUsername(String username){
        return userRepo.findByEmail(username);
    }

}