package co.istad.sm.api.sm_class.web;

import lombok.Builder;

@Builder
public record IsDeletedAndIsWeekendStatusDto(boolean isDeletedStatus, boolean isWeekendStatus) {
}
