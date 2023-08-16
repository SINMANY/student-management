package co.istad.sm.util;

import co.istad.sm.api.file.web.FileDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Component
@Getter
public class FileUtil {

    @Value("${file.server-path}")
    private String fileServerPath;

    @Value("${file.base-url}")
    private String fileBaseUrl;

    @Value("${file.download-url}")
    private String fileDownloadUrl;


    public FileDto upload(MultipartFile file) {
        String extension = getExtension(Objects.requireNonNull(file.getOriginalFilename()));
        Long size = file.getSize();
        String name = String.format("%s.%s", UUID.randomUUID().toString(), extension);
        String url = String.format("%s%s",fileBaseUrl,name);

        Path path = Paths.get(fileServerPath + name);

        try {
            Files.copy(file.getInputStream(), path);
            return FileDto.builder()
                    .name(name)
                    .url(url)
                    .extension(extension)
                    .size(size)
                    .build();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Upload file failed!");
        }
    }
    public String getExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastDotIndex + 1);
    }

    public Resource findFileByName(String name){
        Path path = Paths.get(fileServerPath + name);
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "File is not found!");

        }catch (MalformedURLException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        }
    }

    public FileDto deleteFileByName(String name){
        Path path = Paths.get(fileServerPath + name);
        try {
            boolean isDeleted = Files.deleteIfExists(path);
            if (!isDeleted){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "File is not found!");
            }
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "File is failed to delete!");
        }
        return FileDto.builder()
                .name(name)
                .extension(getExtension(name))
                .build();
    }

}
