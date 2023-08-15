package co.istad.sm.api.sm_class.web;

public record UpdateClassDto(String shift,
                             String startTime,
                             String endTime,

                             Boolean isDeleted,

                             Boolean isWeekend) {
}
