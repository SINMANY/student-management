package co.istad.sm.api.sm_class;

import org.apache.ibatis.jdbc.SQL;

public class ClassProvider {

    private static final String tableName = "classes";

    public String buildAddNewCourseSql(){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("shift","#{c.shift}");
            VALUES("start_time","#{c.startTime}");
            VALUES("end_time","#{c.endTime}");
            VALUES("user_id", "#{c.userId}");
            VALUES("course_id", "#{c.courseId}");
        }}.toString();
    }
}
