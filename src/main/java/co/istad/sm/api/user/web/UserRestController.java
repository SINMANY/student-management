package co.istad.sm.api.user.web;

import co.istad.sm.base.BastRest;
import co.istad.sm.api.user.UserService;
import com.github.pagehelper.PageInfo;
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
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been created successfully")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @GetMapping("/{id}")

    public BastRest<?> findUserById(@PathVariable Integer id){
        UserDto userDto = userService.findUserById(id);
//        log.info("Dto = {}", userDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found successfully")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @GetMapping

    public BastRest<?> findAllUsers(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                    @RequestParam(name = "limit", required = false, defaultValue = "20") int limit,
                                    @RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
                                    @RequestParam(name = "lastName", required = false, defaultValue = "") String lastName){
        PageInfo<UserDto> userDtoPageInfo = userService.findAllUsers(page, limit, firstName, lastName);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found successfully.")
                .timeStamp(LocalDateTime.now())
                .data(userDtoPageInfo)
                .build();
    }

    @DeleteMapping("/{id}")

    public BastRest<?> deleteUserById(@PathVariable Integer id){
        Integer deletedId = userService.deleteUserById(id);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(deletedId)
                .build();
    }
    @PutMapping("/{id}/update-is-deleted-status")

    public BastRest<?> updateIsDeletedStatusById(@PathVariable Integer id, @RequestBody IsDeletedDto isDeletedDto){
        Integer deletedId = userService.updateIsDeletedStatusById(id, isDeletedDto.status() );
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(deletedId)
                .build();
    }

    @PutMapping("/{id}")

    public BastRest<?> updateUserById(@PathVariable("id") Integer id, @RequestBody UpdateUserDto updateUserDto){
        UserDto userDto = userService.updateUserById(id, updateUserDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been updated successfully.")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

}
