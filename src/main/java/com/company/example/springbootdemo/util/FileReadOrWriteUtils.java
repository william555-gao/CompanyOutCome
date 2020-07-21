package com.company.example.springbootdemo.util;

import lombok.extern.log4j.Log4j2;

import java.io.*;

/**
 * @ClassName:FileUploadUtils
 * @Descirpiton: TODO
 * @Author: Gaoww
 * @Date: 2020/6/28 8:44
 * @Version: 1.0
 */
@Log4j2
public class FileReadOrWriteUtils {


    /**
     *@Author:Gaoww
     *@Description: bufferedreader 读取数据
     *@Date 12:19 2020/6/28
     *@Param [fileUrl]
     *@return java.lang.String

     **/
    public static String bufferReader(String fileUrl) {
        StringBuffer bf = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileUrl),"utf-8"));
            String lineStr = null;
            while (null != (lineStr = br.readLine())) {
                bf.append(lineStr);

            }
            br.close();
        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
        return bf.toString();
    }
    /**
     *@Author:Gaoww
     *@Description: bufferedwriter 写入数据到文件
     *@Date 12:19 2020/6/28
     *@Param [content, fileName, filePath]
     *@return void

     **/
    public static void bufferWriter(String content, String fileName, String filePath) {
        BufferedWriter br  = null;
        try {
            br  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath+"\\"+fileName,true)));
            br.write(content,0,content.getBytes().length);
        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }finally{
            try {
                br.flush();
                br.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }
}
