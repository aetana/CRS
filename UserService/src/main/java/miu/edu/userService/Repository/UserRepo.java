package miu.edu.userService.Repository;

import miu.edu.userService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String username);
}
