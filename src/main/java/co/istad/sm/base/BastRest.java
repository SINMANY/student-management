package co.istad.sm.base;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record BastRest<T>(Boolean status,
                          Integer code,
                          String message,
                          LocalDateTime timeStamp,
                          T data) {
}
