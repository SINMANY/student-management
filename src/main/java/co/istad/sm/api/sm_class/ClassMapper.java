package co.istad.sm.api.sm_class;

import co.istad.sm.api.course.Course;
import co.istad.sm.api.sm_class.web.ClassDto;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ClassMapper {

    @InsertProvider(type = ClassProvider.class)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("c") SmClass smClass);

    @SelectProvider(type = ClassProvider.class)
    @Results(id = "classResultMap", value = {
            @Result(column = "shift", property = "shift"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "is_deleted", property = "isDeleted"),
            @Result(column = "is_weekend", property = "isWeekend"),
            @Result(column = "course_id", property = "courses", one = @One(select = "selectCourses"))
    })
    List<SmClass> buildSelectClassSql();

    @SelectProvider(type = ClassProvider.class)
    @ResultMap("classResultMap")
    Optional<SmClass> selectClassById(@Param("id") Integer id);


    @Select("SELECT * FROM courses WHERE id =#{id}")
    List<Course> selectCourses(@Param("id") Integer id);

    @Select("SELECT EXISTS(SELECT * FROM classes WHERE id=#{id})")
    boolean isExistedById(@Param("id") Integer id);

    @DeleteProvider(type = ClassProvider.class)
    void deletedById(@Param("id") Integer id);

    @UpdateProvider(type = ClassProvider.class)
    void updateIsDeletedAndIsWeekendStatusById(@Param("id") Integer id,
                                         @Param("isDeletedStatus") boolean isDeletedStatus,
                                         @Param("isWeekendStatus") boolean isWeekendStatus);

    @UpdateProvider(type = ClassProvider.class)
    void UpdateClassById(@Param("c") SmClass smClass);

}
