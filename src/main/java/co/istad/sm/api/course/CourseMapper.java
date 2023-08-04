package co.istad.sm.api.course;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CourseMapper {

    @InsertProvider(type = CourseProvider.class, method = "buildInsertCourseSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("c") Course course);

    @SelectProvider(type = CourseProvider.class, method = "buildSelectCourseByIdSql")
    @Results(id = "courseResultMap", value = {
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description"),
            @Result(column = "is_deleted", property = "isDeleted")
    })
    Optional<Course> selectCourseById(@Param("id") Integer id);

    @Select("SELECT EXISTS(SELECT * FROM courses WHERE id=#{id})")
    boolean isCourseExisting(@Param("id") Integer id);

    @DeleteProvider(type = CourseProvider.class, method = "buildDeleteCourseByIdSql")
    void deleteCourseById(@Param("id") Integer id);

    @SelectProvider(type = CourseProvider.class, method = "buildSelectAllCoursesSql")
    @ResultMap("courseResultMap")
    List<Course> selectAllCourses();

    @UpdateProvider(type = CourseProvider.class, method = "buildUpdateIsDeletedStatusSql")
    void updateIsDeletedStatusById(@Param("id") Integer id, @Param("status") boolean status);

    @UpdateProvider(type = CourseProvider.class, method = "buildUpdateCourseByIdSql")
    void updateCourseById(@Param("c") Course course);
}
