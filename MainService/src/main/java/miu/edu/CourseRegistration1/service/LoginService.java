package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.model.LoginRequest;
import miu.edu.CourseRegistration1.model.LoginResponse;
import miu.edu.CourseRegistration1.model.RefreshTokenRequest;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
