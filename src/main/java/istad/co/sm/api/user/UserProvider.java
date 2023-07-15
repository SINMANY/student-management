package istad.co.sm.api.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    private static final String tableName = "users";

    public String buildInsertSql(){
        return new SQL(){{

            INSERT_INTO(tableName);
            VALUES("first_name","#{u.firstName}");
            VALUES("last_name","#{u.lastName}");
            VALUES("gender","#{u.gender}");
            VALUES("dob","#{u.dob}");
            VALUES("pob", "#{u.pob}");
            VALUES("current_address","#{u.currentAddress}");
            VALUES("email","#{u.email}");
            VALUES("phone_number","#{u.phoneNumber}");
            VALUES("photo_url", "#{u.photoUrl}");
            VALUES("is_deleted","FALSE");
            VALUES("education","#{u.education}");
        }}.toString();
    }


    public String buildSelectByIdSql(@Param("id") Integer id){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id=#{id}");
        }}.toString();
    }
}
