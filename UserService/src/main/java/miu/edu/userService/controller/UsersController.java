package miu.edu.userService.controller;

import lombok.AllArgsConstructor;
import miu.edu.userService.model.Users;
import miu.edu.userService.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    UserService userService;

    @GetMapping("/{username}")
    public Users getUser(@PathVariable String username){
        System.out.println(" here " + username);
        return userService.getUserByUsername(username);
    }

}
