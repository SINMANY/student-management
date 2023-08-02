package co.istad.sm.api.sm_class;

import co.istad.sm.api.sm_class.web.ClassDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper(componentModel = "spring")
public interface ClassMapStruct {

    SmClass addClassDtoToClass(ClassDto addNewCourseDto);
    ClassDto classToClassDto(SmClass smClass);
}
