package co.istad.sm.api.sm_class.web;


import co.istad.sm.api.course.Course;
import lombok.Builder;

import java.util.List;

@Builder
public record ClassDto(String shift,
                       String startTime,
                       String endTime,

                       Boolean isDeleted,

                       Boolean isWeekend,
                       List<Course> courses
) {
}
