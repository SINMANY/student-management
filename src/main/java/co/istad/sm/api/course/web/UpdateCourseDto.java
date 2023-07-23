package co.istad.sm.api.course.web;

public record UpdateCourseDto(String name,
                              String description,
                              Float fee,
                              Integer hour,
                              String level) {
}
