package co.istad.sm.api.user;

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
            VALUES("email","#{u.email}");
            VALUES("phone_number","#{u.phoneNumber}");
            VALUES("photo_url", "#{u.photoUrl}");
            VALUES("is_deleted","FALSE");
            VALUES("education","#{u.education}");
        }}.toString();
    }


    public String buildSelectByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id=#{id}", "is_deleted=FALSE");
        }}.toString();
    }

    public String buildSelectAllUserSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("first_name Ilike '%' || #{firstName} || '%' OR last_name Ilike '%' || #{lastName} || '%' AND is_deleted=FALSE");
            ORDER_BY("id DESC");
        }}.toString();
    }

    public String buildDeleteUserByIdSql(){
        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id=#{id}");
        }}.toString();
    }

    public String buildUpdateIsDeletedStatusByIdSql(){
        return new SQL(){{
            UPDATE(tableName);
            SET("is_deleted=#{status}");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String buildUpdateUserByIdSql(){
        return new SQL(){{
            UPDATE(tableName);
            SET("first_name=#{u.firstName}");
            SET("last_name=#{u.lastName}");
            SET("gender=#{u.gender}");
            SET("dob=#{u.dob}");
            WHERE("id=#{u.id}");
        }}.toString();
    }
}
