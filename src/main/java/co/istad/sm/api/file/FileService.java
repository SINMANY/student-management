package co.istad.sm.api.file;

import co.istad.sm.api.file.web.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FileService {

    /**
     * uses to upload a single file
     * @param file request form data from client
     * @return fileDto
     */
    FileDto uploadSingleFile(MultipartFile file);

    /**
     * uses to upload multiple files
     * @param files request form data from client
     * @return fileDto
     */
    List<FileDto> uploadMultiple(List<MultipartFile> files);
}
