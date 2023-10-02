package ad.sogeti.filmlandservice.controller.user;

import ad.sogeti.filmlandservice.model.user.LoginRequest;
import ad.sogeti.filmlandservice.model.user.LoginResponse;
import ad.sogeti.filmlandservice.model.user.User;
import ad.sogeti.filmlandservice.service.UserService;
import ad.sogeti.filmlandservice.utils.FilmLandConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="User service")
@RestController
@RequestMapping(FilmLandConstants.USER_BASE_URL)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = FilmLandConstants.LOGIN_ENDPOINT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "User Login Validation",
            description = "Validates the user's authentication"
    )
    public ResponseEntity<LoginResponse> validateUser(@RequestBody LoginRequest userLogin) throws Exception {
        return userService.validateUser(userLogin);
    }

    @PostMapping(value = FilmLandConstants.ADD_ENDPOINT,
            produces = MediaType.TEXT_HTML_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Add User",
            description = "Add a new user"
    )
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }
}
