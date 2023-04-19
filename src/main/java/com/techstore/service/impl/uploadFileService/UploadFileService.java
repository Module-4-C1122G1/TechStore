package com.techstore.service.impl.uploadFileService;

import com.techstore.service.IUploadFileService.IUploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFileService implements IUploadFileService {
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\ADMIN\\Desktop\\techStoreFinal\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename()));
    }

    @Override
    public File convertPathToFile(String path) {
        return new File("C:/Users/ADMIN/Desktop/techStoreFinal/src/main/resources/static" + path);
    }
}