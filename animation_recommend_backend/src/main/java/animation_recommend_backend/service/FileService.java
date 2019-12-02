package animation_recommend_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {
    String uploadFile(MultipartFile file,String directory);//返回上传文件的url路径
    boolean isFileExist(String filename);//检测当前文件是否为从服务器下载的
}
