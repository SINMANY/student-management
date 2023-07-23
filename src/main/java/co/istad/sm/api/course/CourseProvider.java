package co.istad.sm.api.course;

import org.apache.ibatis.jdbc.SQL;

public class CourseProvider {

    private static final String tableName = "courses";

    public String buildInsertCourseSql(){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("name","#{c.name}");
            VALUES("description","#{c.description}");
            VALUES("fee","#{c.fee}");
            VALUES("hour","#{c.hour}");
            VALUES("level","#{c.level}");
            VALUES("is_deleted","FALSE");
        }}.toString();
    }

    public String buildSelectCourseByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id=#{id}", "is_deleted=FALSE");
        }}.toString();
    }

    public String buildDeleteCourseByIdSql(){
        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id=#{id}");
        }}.toString();
    }

    public String buildSelectAllCoursesSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("is_deleted=FALSE");
            ORDER_BY("id ASC");
        }}.toString();
    }

    public String buildUpdateIsDeletedStatusSql(){
        return new SQL(){{
            UPDATE(tableName);
            SET("is_deleted=#{status}");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String buildUpdateCourseByIdSql(){
        return new SQL(){{
            UPDATE(tableName);
            SET("name=#{c.name}");
            SET("description=#{c.description}");
            SET("fee=#{c.fee}");
            SET("hour=#{c.hour}");
            SET("level=#{c.level}");
            WHERE("id=#{c.id}");
        }}.toString();
    }
}
