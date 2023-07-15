package istad.co.sm.api.user;

import istad.co.sm.api.user.web.CreateUserDto;
import istad.co.sm.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User createUserDtoToUser(CreateUserDto createUserDto);
    UserDto userToUserDto(User user);
    User userDtoToUser(User user);
}

