package co.istad.sm.api.user;

import co.istad.sm.api.auth.web.RegisterDto;
import co.istad.sm.api.user.web.CreateUserDto;
import co.istad.sm.api.user.web.UpdateUserDto;
import co.istad.sm.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User createUserDtoToUser(CreateUserDto createUserDto);
    UserDto userToUserDto(User user);
    PageInfo<UserDto> userPageInfoToUserDtoPageInfo(PageInfo<User> userPageInfo);
    User updateUserDtoToUser(UpdateUserDto updateUserDto);
    User registerDtoToUser(RegisterDto registerDto);
}

