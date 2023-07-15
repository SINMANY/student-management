package istad.co.sm.api.user;

import istad.co.sm.api.user.web.CreateUserDto;
import istad.co.sm.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;
    @Override
    public UserDto createNewUser(CreateUserDto createNewUser) {

        User user = userMapStruct.createUserDtoToUser(createNewUser);
        userMapper.insert(user);
            return userMapStruct.userToUserDto(user);
    }

    @Override
    public UserDto findUserById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with id %d not found", id)));
        return userMapStruct.userToUserDto(user);
    }
}
