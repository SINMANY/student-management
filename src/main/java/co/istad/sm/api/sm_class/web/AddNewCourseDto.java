package co.istad.sm.api.sm_class.web;

import co.istad.sm.api.course.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.List;

@Builder
public record AddNewCourseDto(@NotBlank(message = "Shift is required!") String shift,
                              @NotBlank(message = "Start time is required!") String startTime,
                              @NotBlank(message = "End time is required!") String endTime,
                              @NotBlank(message = "Course ID is required!") List<Course> courses) {
}
