package ad.sogeti.filmlandservice.service;

import ad.sogeti.filmlandservice.model.user.LoginRequest;
import ad.sogeti.filmlandservice.model.user.LoginResponse;
import ad.sogeti.filmlandservice.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    ResponseEntity<LoginResponse> validateUser(LoginRequest userLogin) throws Exception;

    ResponseEntity<String> addUser(@RequestBody User user) throws Exception;
}
