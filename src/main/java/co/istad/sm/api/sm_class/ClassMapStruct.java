package co.istad.sm.api.sm_class;

import co.istad.sm.api.sm_class.web.ClassDto;
import co.istad.sm.api.sm_class.web.UpdateClassDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper(componentModel = "spring")
public interface ClassMapStruct {

    SmClass addClassDtoToClass(ClassDto addNewCourseDto);
    ClassDto classToClassDto(SmClass smClass);
    List<ClassDto> toEntityClass(List<SmClass> smClasses);

    SmClass updateClassDtoToClass(UpdateClassDto updateClassDto);
}
