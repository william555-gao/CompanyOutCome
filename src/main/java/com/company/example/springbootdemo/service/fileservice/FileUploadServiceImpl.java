package com.company.example.springbootdemo.service.fileservice;

import com.company.example.springbootdemo.entity.LoginBO;
import com.company.example.springbootdemo.util.CommonConstant;
import com.company.example.springbootdemo.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName:FileUploadServiceImpl
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/7/8 11:33
 * @Version: 1.0
 */
@Service
@Log4j2
public class FileUploadServiceImpl implements FileUploadService {

    public static final String FILE_TYPE_ERROR = "A0421";
    public static final String INPUT_PARAM_ERROR = "A0430";
    public static final String TRANSFORM_IMAGE_ERROR = "A0507";
    public static final String UPLOAD_IMAGES_ERROR = "A0508";


    @Value("${url.image}")
    private String imgUrl;


    @Override
    public LoginBO uploadFile(MultipartFile file, String floder, String username) {
        LoginBO loginBO = new LoginBO();
        //获取文件名 并判断是否为图片文件
        String imgFileName = file.getOriginalFilename();
        if (!imgFileName.matches("^.+\\.(jpg|png|gif)$")) {
            log.warn("文件类型错误");
            loginBO.setResultStatusCode(FILE_TYPE_ERROR);
            return loginBO;
        }
        //判断是否为恶意程序转换为图片对象
        try {
            BufferedImage buffRead = ImageIO.read(file.getInputStream());
            int width = buffRead.getWidth();
            int height = buffRead.getHeight();
            if (width == 0 || height == 0) {
                log.warn("传输文件异常");
                loginBO.setResultStatusCode(INPUT_PARAM_ERROR);
                return loginBO;
            }
            String formatDateUrl = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            String fileSavePath = imgUrl + floder + formatDateUrl;
            String replaceStr = fileSavePath.replace("/", "\\");
            File file1 = new File(replaceStr);
            //判断存储路径是否存在
            if (!file1.exists()) {
                //创建路径
                file1.mkdirs();
            }
            int index = imgFileName.lastIndexOf(".");
            String fileTypeName = imgFileName.substring(index);
            String uuid = UUID.randomUUID().toString();
            String fileRealName = username + "_" + uuid;
            String fileOnDiskUrl = replaceStr + "\\" + fileRealName + fileTypeName;
            file.transferTo(new File(fileOnDiskUrl));
            if (floder.contains(CommonConstant.FLODER_BUSINESSLICENSE)) {
                loginBO.setCompanyImageUrl(fileOnDiskUrl);
            } else if (floder.contains(CommonConstant.FLODER_HEADPORTRAITS)) {
                loginBO.setStaffProfilePhotoUrl(fileOnDiskUrl);
            } else if (floder.contains(CommonConstant.FLODER_CERTIFICATE)) {
                loginBO.setStaffCertifficareUrl(fileOnDiskUrl);
            }
            loginBO.setResultStatusCode(CommonConstant.RETURN_KEY_SUCCESS);
            log.info("路径:" + replaceStr + "; 新增文件:" + fileRealName + "; 文件类型:" + fileTypeName);
        } catch (IOException e) {
            log.error("转换图片异常", e);
            loginBO.setResultStatusCode(TRANSFORM_IMAGE_ERROR);
        }
        return loginBO;
    }

    @Override
    public LoginBO uploadFiles(MultipartFile file, MultipartFile file1, String floder, String floder1, String username) {
        LoginBO resultBO = new LoginBO();
        LoginBO loginBO = uploadFile(file, floder, username);
        LoginBO loginBO1 = uploadFile(file1, floder1, username);
        String resultStatusCode1 = loginBO.getResultStatusCode();
        String resultStatusCode2 = loginBO1.getResultStatusCode();
        String staffProfilePhotoUrl = loginBO.getStaffProfilePhotoUrl();
        String staffCertifficareUrl = loginBO1.getStaffCertifficareUrl();
        if (CommonConstant.RETURN_KEY_SUCCESS.equals(resultStatusCode1) && CommonConstant.RETURN_KEY_SUCCESS.equals(resultStatusCode2)) {
            resultBO.setResultStatusCode(CommonConstant.RETURN_KEY_SUCCESS);
            if (!Utils.isNull(staffProfilePhotoUrl)) {
                resultBO.setStaffProfilePhotoUrl(staffProfilePhotoUrl);
            }
            if (!Utils.isNull(staffCertifficareUrl)) {
                resultBO.setStaffCertifficareUrl(staffCertifficareUrl);
            }
        } else {
            if (resultStatusCode1.equals(resultStatusCode2)) {
                resultBO.setResultStatusCode(resultStatusCode1);
            } else {
                resultBO.setResultStatusCode(UPLOAD_IMAGES_ERROR);
            }
        }
        return resultBO;
    }
}
