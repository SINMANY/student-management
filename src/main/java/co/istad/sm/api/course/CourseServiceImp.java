package co.istad.sm.api.course;

import co.istad.sm.api.course.web.CourseDto;
import co.istad.sm.api.course.web.CreateCourseDto;
import co.istad.sm.api.course.web.UpdateCourseDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {


    private final CourseMapper courseMapper;
    private final CourseMapStruct courseMapStruct;


    @Override
    public CourseDto createNewCourse(CreateCourseDto createCourseDto) {
        Course course = courseMapStruct.createCourseDtoToCourse(createCourseDto);
        courseMapper.insert(course);
        return null;
    }

    @Override
    public CourseDto selectCourseById(Integer id) {
        Course course = courseMapper.selectCourseById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Course with id %d is not found!", id)));
        return courseMapStruct.CourseToCourseDto(course);
    }

    @Override
    public Integer deleteCourseById(Integer id) {
        boolean existed = courseMapper.isCourseExisting(id);
        if (existed) {
            courseMapper.deleteCourseById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Course with id %d is not found!", id));
    }

    @Override
    public PageInfo<CourseDto> selectAllCourses(int page, int limit) {
        PageInfo<Course> coursePageInfo = PageHelper.startPage(page, limit).doSelectPageInfo(courseMapper::selectAllCourses);
        return courseMapStruct.coursePageInfoToCourseDtoPageInfo(coursePageInfo);
    }

    @Override
    public Integer updateIsDeletedStatusById(Integer id, boolean status) {
        boolean existed = courseMapper.isCourseExisting(id);
        if (existed){
            courseMapper.updateIsDeletedStatusById(id, status);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Course with id %d is not found!", id));
    }

    @Override
    public CourseDto updateCourseById(Integer id, UpdateCourseDto updateCourseDto) {
        if (courseMapper.isCourseExisting(id)){
            Course course = courseMapStruct.updateCourseDtoToCourse(updateCourseDto);
            course.setId(id);
            courseMapper.updateCourseById(course);
            return this.selectCourseById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with %d is not found", id));
    }
}
