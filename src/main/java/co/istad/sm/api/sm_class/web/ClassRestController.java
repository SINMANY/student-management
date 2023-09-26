package co.istad.sm.api.sm_class.web;

import co.istad.sm.api.sm_class.ClassService;
import co.istad.sm.base.BastRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
@Slf4j
public class ClassRestController {

    private final ClassService classService;

    @PostMapping
    public BastRest<?> addNewClass(@RequestBody @Valid ClassDto addNewCourseDto){
//        log.info(addNewCourseDto.toString());
        ClassDto classDto = classService.addNewCourse(addNewCourseDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(classDto)
                .build();
    }

    @GetMapping("/{id}")
    public BastRest<?> selectClassById(@PathVariable Integer id){
        ClassDto classDto = classService.selectClassById(id);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(classDto)
                .build();
    }

    @GetMapping()
    public BastRest<?> selectClassAll(){
        List<ClassDto> classDto = classService.findAll();
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(classDto)
                .build();
    }

    @DeleteMapping("/{id}")
    public BastRest<?> deleteClassById(@PathVariable Integer id){
        Integer deletedId = classService.deleteClassById(id);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(deletedId)
                .build();
    }

    @PutMapping("/updateStatus/{id}")
    public BastRest<?> updateIsDeletedAndIsWeekendStatus(@PathVariable Integer id,
                                                         @RequestBody IsDeletedAndIsWeekendStatusDto
                                                                 isDeletedAndIsWeekendStatusDto){
        Integer isDeletedAndIsWeekendStatus = classService.deleteIsDeletedAndIsWeekendStatusById(id,
                isDeletedAndIsWeekendStatusDto.isDeletedStatus(),
                isDeletedAndIsWeekendStatusDto.isWeekendStatus());
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(isDeletedAndIsWeekendStatus)
                .build();
    }

    @PutMapping("/{id}")
    public BastRest<?> updateClassById(@PathVariable("id") Integer id, @RequestBody UpdateClassDto updateClassDto){
        ClassDto updateClass = classService.updateClassById(id, updateClassDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Class has been added successfully")
                .timeStamp(LocalDateTime.now())
                .data(updateClass)
                .build();
    }
}
