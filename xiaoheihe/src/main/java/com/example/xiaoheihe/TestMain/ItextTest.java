package com.example.xiaoheihe.TestMain;

import com.lowagie.text.Document;
import com.lowagie.text.rtf.RtfWriter2;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ItextTest {


    public static void main(String[] args) throws IOException {

//        System.out.println(ItextTest.class.getResource("/templates/test.txt").getFile());
        File file = new ClassPathResource("/templates/test.txt").getFile();
//        System.out.println(file.toPath());


//        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String str = "test20230214";
//        FileChannel channel = fileOutputStream.getChannel();
        FileChannel fileChannel = new RandomAccessFile(new ClassPathResource("/templates/test.txt").getFile(), "rw").getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(5000);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.remaining()];
        int i = 0;
        while(byteBuffer.hasRemaining()){
            bytes[i++] = byteBuffer.get();
        }

        System.out.println(new String(bytes));
//        byteBuffer.reset();
        fileChannel.write(ByteBuffer.wrap(str.getBytes()));
        fileChannel.close();

//        genWord();
    }

    private static void genWord() throws IOException {
        Document document = new Document();

        try {
            RtfWriter2.getInstance(document,new FileOutputStream(new ClassPathResource("/templates/电子化封样信息表.docx").getFile()));
            document.open();

        }

        finally {
            document.close();
        }
    }


}
