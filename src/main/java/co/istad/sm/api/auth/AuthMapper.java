package co.istad.sm.api.auth;

import co.istad.sm.api.user.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthMapper {

    @InsertProvider(type = AuthProvider.class, method = "buildRegisterSql")
    void register(@Param("u") User user);
}
