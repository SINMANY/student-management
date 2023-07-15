package istad.co.sm.base;

import lombok.Builder;
import org.apache.ibatis.mapping.CacheBuilder;

import java.time.LocalDateTime;
@Builder
public record BastRest<T>(Boolean status,
                          Integer code,
                          String message,
                          LocalDateTime timeStamp,
                          T data) {
}
