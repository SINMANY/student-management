package istad.co.sm.api.user.web;

import istad.co.sm.base.BastRest;
import istad.co.sm.api.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    // Create a new User

    @PostMapping
    public BastRest<?> createNewUser(@RequestBody @Valid CreateUserDto createUserDto){
//        log.info("Dto = {}", createUserDto);
        UserDto userDto = userService.createNewUser(createUserDto);
        return BastRest.builder()
                .status(false)
                .code(HttpStatus.OK.value())
                .message("User has been created successfully")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @GetMapping("/id")

    public BastRest<?>  findAccountTypeById(@PathVariable Integer id){
        UserDto userDto = userService.findUserById(id);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account type found successfully")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }


}
