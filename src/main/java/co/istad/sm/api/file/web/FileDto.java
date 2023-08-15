package co.istad.sm.api.file.web;

public record FileDto(String extension,
                      String name,
                      Long size,
                      String url,
                      String download) {
}
