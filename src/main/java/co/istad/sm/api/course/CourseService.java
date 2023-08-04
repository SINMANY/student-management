package co.istad.sm.api.course;

import co.istad.sm.api.course.web.CourseDto;
import co.istad.sm.api.course.web.CreateCourseDto;
import co.istad.sm.api.course.web.UpdateCourseDto;
import com.github.pagehelper.PageInfo;

public interface CourseService {

    CourseDto createNewCourse(CreateCourseDto createCourseDto);
    CourseDto selectCourseById(Integer id);
    Integer deleteCourseById(Integer id);
    PageInfo<CourseDto> selectAllCourses(int page, int limit);
    Integer updateIsDeletedStatusById(Integer id, boolean status);
    CourseDto updateCourseById(Integer id, UpdateCourseDto updateCourseDto);
}
