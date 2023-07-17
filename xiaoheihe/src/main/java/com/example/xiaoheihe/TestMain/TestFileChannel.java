package com.example.xiaoheihe.TestMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(TestFileChannel.class.getClassLoader().getResource("config/auth_key/id_key_rsa").getPath());
        FileOutputStream fileOutputStream = new FileOutputStream(TestFileChannel.class.getClassLoader().getResource("config/testchannel.txt").getPath());
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        inChannel.transferTo(0,inChannel.size(),outChannel);
    }
}
