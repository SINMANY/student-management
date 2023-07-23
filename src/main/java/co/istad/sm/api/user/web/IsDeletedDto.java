package co.istad.sm.api.user.web;

import lombok.Builder;

@Builder
public record IsDeletedDto(boolean status) {
}
