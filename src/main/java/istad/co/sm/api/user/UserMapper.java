package istad.co.sm.api.user;



import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @InsertProvider(type = UserProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type =  UserProvider.class, method = "buildSelectByIdSql")
    @Results(id = "userResultMap", value = {
            @Result(column="first_name", property = "firstName"),
            @Result(column="last_name" , property = "lastName"),
            @Result(column="current_address", property = "currentAddress"),
            @Result(column="phone_number" , property = "phoneNumber"),
            @Result(column="is_deleted", property = "isDeleted"),
            @Result(column="photo_url" , property = "photoUrl"),

    })
    Optional<User> selectById(@Param("id") Integer id);




}
