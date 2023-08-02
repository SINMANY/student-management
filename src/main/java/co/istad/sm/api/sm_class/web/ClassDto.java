package co.istad.sm.api.sm_class.web;


import co.istad.sm.api.user.User;
import lombok.Builder;

@Builder
public record ClassDto(String shift,
                       String startTime,
                       String endTime
) {
}
