package co.istad.sm.api.user;

import co.istad.sm.api.user.web.CreateUserDto;
import co.istad.sm.api.user.web.UpdateUserDto;
import co.istad.sm.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;

public interface UserService {

    /**
     * uses to create a new user
     * @param createNewUser request data from user
     * @return userDto
     */
    UserDto createNewUser(CreateUserDto createNewUser);

    /**
     * uses to fine user by id
     * @param id request id from user
     * @return userDto
     */
    UserDto findUserById(Integer id);

    /**
     * uses to delete user by id
     * @param id request id from user
     * @return deleted if id existing
     */
    Integer deleteUserById(Integer id);

    /**
     * uses to update isDeleted status of user by id
     * @param id request from user
     * @param status user need to input true for false
     * @return updated by id
     */
    Integer updateIsDeletedStatusById(Integer id, boolean status);

    /**
     * uses to search user by name
     * @param page request any page
     * @param limit request how many users
     * @param firstName request first name
     * @param lastName request last name
     * @return userDto
     */
    PageInfo<UserDto> findAllUsers(int page, int limit, String firstName, String lastName);

    /**
     * uses to update user by id
     * @param id request from user
     * @param updateUserDto request field to update
     * @return userDto
     */
    UserDto updateUserById(Integer id, UpdateUserDto updateUserDto);
}
