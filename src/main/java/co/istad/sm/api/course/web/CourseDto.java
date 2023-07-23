package co.istad.sm.api.course.web;

public record CourseDto(String name,
                        String description,
                        Float fee,
                        Integer hour,
                        String level,
                        Boolean isDeleted) {
}
