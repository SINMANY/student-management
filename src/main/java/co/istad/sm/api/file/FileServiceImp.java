package co.istad.sm.api.file;

import co.istad.sm.api.file.web.FileDto;
import co.istad.sm.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class FileServiceImp implements FileService {

   private FileUtil fileUtil;

    @Value("${file.download-url}")
    private String fileDownloadUrl;

   @Autowired
   public void setFileUtil(FileUtil fileUtil){
       this.fileUtil = fileUtil;
   }
    @Override
    public FileDto uploadSingleFile(MultipartFile file) {
       return fileUtil.upload(file);
    }

    @Override
    public List<FileDto> uploadMultiple(List<MultipartFile> files) {
        List<FileDto> fileDto = new  ArrayList<>();
        for (MultipartFile file : files){
            fileDto.add(fileUtil.upload(file));
        }
       return fileDto;
    }

    @Override
    public FileDto findFileByName(String name) throws IOException {
       Resource resource = fileUtil.findFileByName(name);
       return FileDto.builder()
               .name(resource.getFilename())
               .extension(fileUtil.getExtension(Objects.requireNonNull(resource.getFilename())))
               .url(String.format("%s%s", fileUtil.getFileBaseUrl(), resource.getFilename()))
               .download(String.format("%s%s", fileDownloadUrl, name))
               .size(resource.contentLength())
               .build();
    }

    @Override
    public FileDto deleteFileByName(String name) {
       return fileUtil.deleteFileByName(name);
    }

    @Override
    public Resource download(String name) {
        return fileUtil.findFileByName(name);
    }

}
