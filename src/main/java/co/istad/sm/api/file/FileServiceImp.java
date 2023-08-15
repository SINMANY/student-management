package co.istad.sm.api.file;

import co.istad.sm.api.file.web.FileDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileServiceImp implements FileService {
    @Override
    public FileDto uploadSingleFile(MultipartFile file) {
        return null;
    }

    @Override
    public List<FileDto> uploadMultiple(List<MultipartFile> files) {
        return null;
    }
}
