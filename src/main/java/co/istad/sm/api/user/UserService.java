package co.istad.sm.api.user;

import co.istad.sm.api.user.web.CreateUserDto;
import co.istad.sm.api.user.web.UpdateUserDto;
import co.istad.sm.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

//@Service
public interface UserService {

    UserDto createNewUser(CreateUserDto createNewUser);
    UserDto findUserById(Integer id);
    Integer deleteUserById(Integer id);
    Integer updateIsDeletedStatusById(Integer id, boolean status);
    PageInfo<UserDto> findAllUsers(int page, int limit);
    UserDto updateUserById(Integer id, UpdateUserDto updateUserDto);
}
