package co.istad.sm.api.sm_class.web;

import lombok.Builder;

@Builder
public record AddNewCourseDto(String shift,
                              String startTime,
                              String endTime) {
}
