package co.istad.sm.api.course;

import co.istad.sm.api.course.web.CourseDto;
import co.istad.sm.api.course.web.CreateCourseDto;
import co.istad.sm.api.course.web.UpdateCourseDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface CourseMapStruct {
    Course createCourseDtoToCourse(CreateCourseDto createUserDto);
    CourseDto CourseToCourseDto(Course course);
    PageInfo<CourseDto> coursePageInfoToCourseDtoPageInfo(PageInfo<Course> coursePageInfo);
    Course updateCourseDtoToCourse(UpdateCourseDto updateCourseDto);
}
