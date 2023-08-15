package co.istad.sm.api.sm_class;

import co.istad.sm.api.sm_class.web.ClassDto;
import co.istad.sm.api.sm_class.web.UpdateClassDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        return classMapStruct.classToClassDto(smClass);
    }

    @Override
    public ClassDto selectClassById(Integer id) {
        SmClass smClass = classMapper.selectClassById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Class with ID %d is not found!", id)));
        return classMapStruct.classToClassDto(smClass);
    }

    @Override
    public List<ClassDto> findAll() {
        List<SmClass> classDto = classMapper.buildSelectClassSql();
        List<ClassDto> smClass = classMapStruct.toEntityClass(classDto);
        return smClass;
    }

    @Override
    public Integer deleteClassById(Integer id) {
        boolean isExisted = classMapper.isExistedById(id);
        if (isExisted){
            classMapper.deletedById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Class with ID %d is not found!", id));
    }

    @Override
    public Integer deleteIsDeletedAndIsWeekendStatusById(Integer id, boolean isDeletedStatus, boolean isWeekendStatus) {
        boolean isExisted = classMapper.isExistedById(id);
        if (isExisted){
            classMapper.updateIsDeletedAndIsWeekendStatusById(id, isDeletedStatus, isWeekendStatus);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Class with ID %d is not found!", id));
    }

    @Override
    public ClassDto updateClassById(Integer id, UpdateClassDto updateClassDto) {
        boolean isExisted = classMapper.isExistedById(id);
        if (classMapper.isExistedById(id)){
            SmClass smClass = classMapStruct.updateClassDtoToClass(updateClassDto);
            smClass.setId(id);
            classMapper.UpdateClassById(smClass);
            return this.selectClassById(id);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with %d is not found", id));
    }

}
