package miu.edu.CourseRegistration1.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import miu.edu.CourseRegistration1.entity.Role;
import miu.edu.CourseRegistration1.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class AwesomeUserDetails implements UserDetails {

    private String username;

    @JsonIgnore
    private String password;

    private Role role;

    private Long id;


    public AwesomeUserDetails(User users) {

        this.username = users.getUsername();
        this.password = users.getPassword();
        this.role = users.getRole();
        this.id = users.getId();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result= new ArrayList<>();
        result.add(new SimpleGrantedAuthority(this.role.toString()));
        return result;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}