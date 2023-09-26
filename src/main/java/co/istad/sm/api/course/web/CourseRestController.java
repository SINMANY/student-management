package co.istad.sm.api.course.web;

import co.istad.sm.api.course.CourseService;
import co.istad.sm.base.BastRest;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseRestController {

    private final CourseService courseService;

    @PostMapping

    public BastRest<?> createNewCourse(@RequestBody @Valid CreateCourseDto createCourseDto){
        CourseDto courseDto = courseService.createNewCourse(createCourseDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(courseDto)
                .build();
    }

    @GetMapping("/{id}")

    public BastRest<?> selectCourseById(@PathVariable Integer id){
        CourseDto courseDto = courseService.selectCourseById(id);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(courseDto)
                .build();
    }

    @DeleteMapping("/{id}")
    public BastRest<?> deleteCourseById(@PathVariable Integer id){
        Integer deleteCourse = courseService.deleteCourseById(id);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(deleteCourse)
                .build();
    }

    @GetMapping
    public BastRest<?> selectAllCourses(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                        @RequestParam(name = "limit", required = false, defaultValue = "20") int limit){
        PageInfo<CourseDto> courseDtoPageInfo = courseService.selectAllCourses(page, limit);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Course have been found successfully!")
                .timeStamp(LocalDateTime.now())
                .data(courseDtoPageInfo)
                .build();
    }

    @PutMapping("/update-is-deleted-status/{id}")
    public BastRest<?> updateIsDeletedStatusById(@PathVariable Integer id, @RequestBody IsDeletedDto isDeletedDto){
        Integer isDeletedId = courseService.updateIsDeletedStatusById(id, isDeletedDto.status());
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Course has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(isDeletedId)
                .build();
    }

    @PutMapping("/{id}")
    public BastRest<?> updateCourseById(@PathVariable Integer id, @RequestBody UpdateCourseDto updateCourseDto){
        CourseDto courseDto = courseService.updateCourseById(id, updateCourseDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Course has been deleted successfully.")
                .timeStamp(LocalDateTime.now())
                .data(courseDto)
                .build();
    }
}
