package co.istad.sm.api.course.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCourseDto(@NotBlank(message = "Course name is required!") String name,
                              @NotBlank(message = "Description is requited!") String description,
                              @NotNull Float fee,
                              @NotNull Integer hour,
                              @NotBlank(message = "Level is required!") String level) {
}
