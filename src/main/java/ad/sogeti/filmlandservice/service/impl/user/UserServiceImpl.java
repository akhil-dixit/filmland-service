package ad.sogeti.filmlandservice.service.impl.user;

import ad.sogeti.filmlandservice.model.user.LoginRequest;
import ad.sogeti.filmlandservice.model.user.LoginResponse;
import ad.sogeti.filmlandservice.model.user.User;
import ad.sogeti.filmlandservice.repository.user.UserRepository;
import ad.sogeti.filmlandservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<LoginResponse> validateUser(@RequestBody LoginRequest userLogin) throws Exception {
        ResponseEntity responseEntity = null;
        try{
            User user = userRepository.findByEmail(userLogin.getEmail());
            if (userLogin.getEmail().equalsIgnoreCase(user.getEmail())
                    && userLogin.getPassword().equalsIgnoreCase(user.getPassword())){
                logger.info("Login successful for user: " + userLogin.getEmail());
                responseEntity = new ResponseEntity<>(
                        new LoginResponse("Login successful","User authenticated!"), HttpStatus.OK);
            } else {
                logger.info("Login failed for user: " + userLogin.getEmail());
                responseEntity = new ResponseEntity<>(
                        new LoginResponse("Login failed","Invalid email or password!"), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            logger.error("Error occurred in validateUser of UserServiceImpl: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        ResponseEntity responseEntity = null;
        try{
            if (null == userRepository.findByEmail(user.getEmail())) {
                userRepository.save(user);
                logger.info("User: " + user.getEmail() + ", successfully added");
                responseEntity = new ResponseEntity<>("User added successfully!",HttpStatus.CREATED);
            } else {
                logger.info("User: " + user.getEmail() + " already exists");
                responseEntity = new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            logger.error("Error occurred while adding new user: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        return responseEntity;
    }
}
