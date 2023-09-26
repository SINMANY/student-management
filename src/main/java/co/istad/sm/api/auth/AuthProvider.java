package co.istad.sm.api.auth;

import org.apache.ibatis.jdbc.SQL;

public class AuthProvider {

    private static final String tableName = "users";
    public String buildRegisterSql(){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("email","#{u.email}");
            VALUES("password","#{u.password}");
            VALUES("is_verified","#{u.isVerified}");
        }}.toString();

    }
}
