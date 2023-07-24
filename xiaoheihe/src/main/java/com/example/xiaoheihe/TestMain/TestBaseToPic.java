package com.example.xiaoheihe.TestMain;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBaseToPic {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(TestBaseToPic.class.getClassLoader().getResource("images/healthCodeBase64.txt").getPath());
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuffer sb = new StringBuffer();
        while (channel.read(buffer) != -1){
            //读写模式转换
            buffer.flip();
            while (buffer.hasRemaining()){
                sb.append((char)buffer.get());
            }
            buffer.clear();
        }
        System.out.println(sb);
        byte[] bytes = Base64.decodeBase64(sb.toString());

        OutputStream fileOutputStream = new FileOutputStream("D:/QRCode.jpg");
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
