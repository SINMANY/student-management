package co.istad.sm.api.user;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @InsertProvider(type = UserProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type = UserProvider.class, method = "buildSelectByIdSql")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Results(id = "userResultMap", value = {
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName"),
            @Result(column = "current_address", property = "currentAddress"),
            @Result(column = "phone_number", property = "phoneNumber"),
            @Result(column = "is_deleted", property = "isDeleted"),
    })

    Optional<User> selectUserById(@Param("id") Integer id);

    @SelectProvider(type = UserProvider.class, method = "buildSelectAllUserSql")
    @ResultMap("userResultMap")
    List<User> select();

    @Select("SELECT EXISTS(SELECT * FROM users WHERE id = #{id})")
    boolean existsById(@Param("id") Integer id);

    @DeleteProvider(type = UserProvider.class, method = "buildDeleteUserByIdSql")
    void deleteById(@Param("id") Integer id);

    @UpdateProvider(type = UserProvider.class, method = "buildUpdateIsDeletedStatusByIdSql")
    void updateIsDeletedById(@Param("id") Integer id, @Param("status") boolean status);

    @UpdateProvider(type = UserProvider.class, method = "buildUpdateUserByIdSql")
    void updateById(@Param("u") User user);

    @Select("SELECT EXISTS(SELECT * FROM classes WHERE id=#{classId})")
    boolean checkClassId(Integer classId);
}
