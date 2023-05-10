package com.example.xiaoheihe.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadUtils {

    public static void download(HttpServletRequest request, HttpServletResponse response, File file) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","attachment;fileName=" + file.getName());
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fileInputStream.read(bytes)) > 0){
                outputStream.write(bytes,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                fileInputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }
    }
    public static void download(HttpServletRequest request, HttpServletResponse response, InputStream inputStream,String fileName) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("multipart/form-data");
//        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"); //docx
//        response.setContentType("application/msword");  //doc
        response.setContentType("application/pdf"); //pdf
        response.setHeader("Content-Disposition","attachment;fileName=" + fileName);
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();

            byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) > 0){
                outputStream.write(bytes,0,length);
            }
            System.out.println("文件传输结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }
    }
}
