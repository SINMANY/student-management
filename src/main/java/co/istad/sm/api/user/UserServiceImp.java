package co.istad.sm.api.user;

import co.istad.sm.api.user.web.CreateUserDto;
import co.istad.sm.api.user.web.UpdateUserDto;
import co.istad.sm.api.user.web.UserDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
            return this.findUserById(user.getId());
    }

    @Override
    public UserDto findUserById(Integer id) {
        User user = userMapper.selectUserById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with id %d not found!", id)));
        return userMapStruct.userToUserDto(user);
    }


    @Override
    public Integer deleteUserById(Integer id) {
    boolean isExisted= userMapper.existsById(id);
//        System.out.println(isFound);
        if(isExisted){
//            if isFound = true, can call to delete
            userMapper.deleteById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with id %d not found!", id));
    }

    @Override
    public Integer updateIsDeletedStatusById(Integer id, boolean status) {
        boolean isExisted = userMapper.existsById(id);
        if(isExisted){
            userMapper.updateIsDeletedById(id, status);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with id %d not found!", id));
    }

    @Override
    public PageInfo<UserDto> findAllUsers(int page, int limit) {

//        PageHelper.startPage(page, limit).doSelectPageInfo(new ISelect() {
//            @Override
//            public void doSelect() {
//                userMapper.select();
//            }
//        });

//        After replace
       PageInfo<User> userPageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(userMapper::select);

        return userMapStruct.userPageInfoToUserDtoPageInfo(userPageInfo);
    }

    @Override
    public UserDto updateUserById(Integer id, UpdateUserDto updateUserDto) {
        if(userMapper.existsById(id)){
            User user = userMapStruct.updateUserDtoToUser(updateUserDto);
            user.setId(id);
            userMapper.updateById(user);
            return this.findUserById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with %d is not found", id));
    }
}
