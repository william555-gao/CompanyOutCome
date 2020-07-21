package com.company.example.springbootdemo.service.fileservice;

import com.company.example.springbootdemo.entity.LoginBO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName:FileUploadService
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/8 11:33
 * @Version: 1.0
 */
public interface FileUploadService {

    LoginBO uploadFile(MultipartFile file, String floder, String username);

    LoginBO uploadFiles(MultipartFile file, MultipartFile file1, String floder, String floder1, String username);
}
