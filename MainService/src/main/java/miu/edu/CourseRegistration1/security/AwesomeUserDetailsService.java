package miu.edu.CourseRegistration1.security;

import miu.edu.CourseRegistration1.entity.Users;
import miu.edu.CourseRegistration1.rabbitMQ.service.RabbitService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("userDetailsService")
@Transactional
public class AwesomeUserDetailsService implements UserDetailsService {
    private final RabbitService rabbitService;
    private final RestTemplate restTemplate;

    public AwesomeUserDetailsService(RabbitService rabbitService, RestTemplate r) {

        this.rabbitService = rabbitService;
        this.restTemplate = r;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = restTemplate.getForObject("http://localhost:9090/users/"+username, Users.class);

        var userDetails = new AwesomeUserDetails(users);
        return userDetails;
    }

}