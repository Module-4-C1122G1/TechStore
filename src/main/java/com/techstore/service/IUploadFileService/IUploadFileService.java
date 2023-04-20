package com.techstore.service.IUploadFileService;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IUploadFileService {
    void uploadFile(MultipartFile file) throws IOException;
    File convertPathToFile(String path);
}
