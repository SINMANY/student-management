package istad.co.sm.api.user;

import istad.co.sm.api.user.web.CreateUserDto;
import istad.co.sm.api.user.web.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto createNewUser(CreateUserDto createNewUser);
    UserDto findUserById(Integer id);
}
