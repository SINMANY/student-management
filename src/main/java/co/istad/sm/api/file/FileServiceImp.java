package co.istad.sm.api.file;

import co.istad.sm.api.file.web.FileDto;
import co.istad.sm.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class FileServiceImp implements FileService {

   private FileUtil fileUtil;

    @Value("${file.server-path}")
    private String fileServerPath;

    @Value("${file.base-url}")
    private String fileBaseUrl;

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
    public List<FileDto> findAllFiles() {
        List<FileDto> fileDtoList = new ArrayList<>();
        File file = new File(fileServerPath);
        File []allFiles = file.listFiles();
        assert allFiles != null;
        if(allFiles.length==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "There is no file to search!");
        }
        for (File file1: allFiles){
            fileDtoList.add(new FileDto(file1.getName().substring(file1.getName().length()-3),
                    file1.getName(),file1.length(),fileBaseUrl + file1.getName(),
                    fileDownloadUrl + file1.getName()));
        }
        return fileDtoList;
    }

    @Override
    public void deleteFileByName(String name) {
       fileUtil.deleteFileByName(name);
    }

    @Override
    public boolean deleteAllFiles() {
        List<FileDto> fileDtoList = new ArrayList<>();
        File file = new File(fileServerPath);
        File []allFiles = file.listFiles();
        assert allFiles != null;
        for (File file1 : allFiles) {
            file1.delete();
        }
        return true;
    }

    @Override
    public Resource download(String name) {
        return fileUtil.findFileByName(name);
    }

}
