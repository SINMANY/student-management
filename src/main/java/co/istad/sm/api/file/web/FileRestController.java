package co.istad.sm.api.file.web;

import co.istad.sm.api.file.FileService;
import co.istad.sm.base.BastRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@Slf4j
public class FileRestController {

    private final FileService fileService;

    @PostMapping
    public BastRest<?> uploadSingleFile(@RequestPart MultipartFile file)  {
        log.info("File Request = {}", file);
        FileDto fileDto = fileService.uploadSingleFile(file);
        return BastRest.builder()
               .status(true)
               .code(HttpStatus.OK.value())
               .message("File has been uploaded successfully!")
               .timeStamp(LocalDateTime.now())
               .data(fileDto)
               .build();
    }

    @PostMapping("/upload-multiple-file")
    public BastRest<?> uploadMultipleFile(@RequestPart List<MultipartFile> files){
        List<FileDto> fileDto = fileService.uploadMultiple(files);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been uploaded successfully!")
                .timeStamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }

    @GetMapping("/{name}")
    public BastRest<?> findFileByName(@PathVariable String name) throws IOException {
        FileDto fileDto = fileService.findFileByName(name);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been found successfully!")
                .timeStamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/{name}")
    public BastRest<?> deleteFileByName(@PathVariable String name) throws IOException{
        FileDto fileDto = fileService.deleteFileByName(name);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("File has been deleted successfully!")
                .timeStamp(LocalDateTime.now())
                .data(fileDto)
                .build();
    }

    @GetMapping("/download/{name}")
    public ResponseEntity<?> download(@PathVariable String name){
        Resource resource = fileService.download(name);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename="
                        + resource.getFilename())
                .body(resource);
    }
}
