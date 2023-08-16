package co.istad.sm.api.file;

import co.istad.sm.api.file.web.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    /**
     * uses to upload a single file
     * @param file request form data from client
     * @return fileDto
     */
    FileDto uploadSingleFile(MultipartFile file) ;

    /**
     * uses to upload multiple files
     * @param files request form data from client
     * @return fileDto
     */
    List<FileDto> uploadMultiple(List<MultipartFile> files);

    /**
     * uses to find file by name
     * @param name request from user
     * @return fileDto
     * @throws IOException check exception while accessing data from file
     */
    FileDto findFileByName(String name) throws IOException;

    /**
     * uses to delete file by name
     * @param name request from user
     * @return fileDto
     */
    FileDto deleteFileByName(String name);

    /**
     * uses to download file by name
     * @param name request from user
     * @return file
     */
    Resource download(String name);
}
