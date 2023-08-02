package co.istad.sm.api.sm_class;

import co.istad.sm.api.sm_class.web.AddNewCourseDto;
import co.istad.sm.api.sm_class.web.ClassDto;
import org.springframework.stereotype.Service;

//@Service
public interface ClassService {

    ClassDto addNewCourse(ClassDto addNewCourseDto);
}
