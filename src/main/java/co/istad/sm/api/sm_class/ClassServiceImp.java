package co.istad.sm.api.sm_class;

import co.istad.sm.api.sm_class.web.AddNewCourseDto;
import co.istad.sm.api.sm_class.web.ClassDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassServiceImp implements ClassService {

    private final ClassMapper classMapper;
    private final ClassMapStruct classMapStruct;

    @Override
    public ClassDto addNewCourse(ClassDto addNewCourseDto) {
       SmClass smClass = classMapStruct.addClassDtoToClass(addNewCourseDto);
        classMapper.insert(smClass);
        log.info("{}",smClass.getStartTime());
        return classMapStruct.classToClassDto(smClass);
    }
}
