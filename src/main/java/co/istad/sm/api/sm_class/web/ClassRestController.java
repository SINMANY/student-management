package co.istad.sm.api.sm_class.web;

import co.istad.sm.api.sm_class.ClassService;
import co.istad.sm.base.BastRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
@Slf4j
public class ClassRestController {

    private final ClassService classService;

    @PostMapping
    public BastRest<?> addNewClass(@RequestBody ClassDto addNewCourseDto){
        log.info(addNewCourseDto.toString());
        ClassDto classDto = classService.addNewCourse(addNewCourseDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(classDto)
                .build();
    }
}
