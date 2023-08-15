package co.istad.sm.api.sm_class;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class ClassProvider implements ProviderMethodResolver {

    private static final String tableName = "classes";

    public String insert(){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("shift","#{c.shift}");
            VALUES("start_time","#{c.startTime}");
            VALUES("end_time","#{c.endTime}");
            VALUES("course_id","#{c.courses}");
        }}.toString();
    }

    public String selectClassById(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id=#{id}");
        }} .toString();
    }
    public String buildSelectClassSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
        }}.toString();
    }

    public String deletedById(){
        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id=#{id}");
        }}.toString();
    }

    public String updateIsDeletedAndIsWeekendStatusById(){
        return new SQL(){{
            UPDATE(tableName);
            SET("is_deleted=#{isDeletedStatus}");
            SET("is_weekend=#{isWeekendStatus}");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String UpdateClassById(){
        return new SQL(){{
            UPDATE(tableName);
            SET("shift=#{c.shift}");
            SET("start_time=#{c.startTime}");
            SET("end_time=#{c.endTime}");
            SET("is_deleted=#{c.isDeleted}");
            SET("is_weekend=#{c.isWeekend}");
            WHERE("id=#{c.id}");
        }}.toString();
    }
}
