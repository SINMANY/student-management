package co.istad.sm.api.file.web;

import lombok.Builder;

@Builder
public record FileDto(String extension,
                      String name,
                      Long size,
                      String url,
                      String download) {
}
