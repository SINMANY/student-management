package co.istad.sm.api.sm_class;

import co.istad.sm.api.sm_class.web.ClassDto;
import co.istad.sm.api.sm_class.web.UpdateClassDto;

import java.util.List;

//@Service
public interface ClassService {

    ClassDto addNewCourse(ClassDto addNewCourseDto);

    ClassDto selectClassById(Integer id);

    List<ClassDto> findAll();

    Integer deleteClassById(Integer id);

    Integer deleteIsDeletedAndIsWeekendStatusById(Integer id, boolean isDeletedStatus, boolean isWeekendStatus);

    ClassDto updateClassById(Integer id, UpdateClassDto updateClassDto);

}
