package co.istad.sm.api.file.web;

import co.istad.sm.api.file.FileService;
import co.istad.sm.base.BastRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@Slf4j
public class FileRestController {

    private final FileService fileService;

    @PostMapping
    public BastRest<?> uploadSingleFile(@RequestPart MultipartFile file){
        log.info("File Request = {}", file);
        FileDto fileDto = fileService.uploadSingleFile(file);
       return BastRest.builder()
               .status(true)
               .code(HttpStatus.OK.value())
               .message("File has been uploaded!")
               .timeStamp(LocalDateTime.now())
               .data(fileDto)
               .build();
    }
}
