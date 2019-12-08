package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl  implements FileService {
//    String url="killmytime.top:8080/img/";
    String url="localhost:8080/img/";
    @Override
    public String uploadFile(MultipartFile file,String directory) {
        String fileName = file.getOriginalFilename();
        if (isFileExist(fileName)) return url+fileName;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        System.out.println(fileName);
        try {
            file.transferTo(new File("/"+directory+fileName).getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url+fileName;
    }

    @Override
    public boolean isFileExist(String filename) {
        File file=new File("/"+filename);
        return file.exists();
    }
}
