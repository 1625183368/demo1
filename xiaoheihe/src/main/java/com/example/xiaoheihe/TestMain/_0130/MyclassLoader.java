package com.example.xiaoheihe.TestMain._0130;

import org.apache.poi.util.StringUtil;
import org.thymeleaf.util.StringUtils;

import java.io.*;

public class MyclassLoader extends ClassLoader{
    private String path;

    public MyclassLoader(ClassLoader parent, String path) {
        super(parent);
        this.path = path;
    }

    public MyclassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //com.xiaoheihe.demo--->com/xiaoheihe/demo.class
        //D:/ideaProjects/demo1/  + com.xiaoheihe.demo -> D:/ideaProjects/demo1/com/xiaoheihe/demo.class
        if (!StringUtils.isEmpty(path)){
            byte[] bytes = loadClassData(name);
            return super.defineClass(name,bytes,0, bytes.length);
        }

        return super.findClass(name);
    }

    private byte[] loadClassData(String className) throws ClassNotFoundException {
        String filename = className.replace('.',File.separatorChar) + ".class";
        path = path + filename;
        int line = 0;
        byte[] bytes = new byte[1024];
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis= new BufferedInputStream(fis);
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
        ) {
            while ((line = bis.read(bytes)) != -1){
                bos.write(bytes,0,line);
            }
            bos.flush();
            return bos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(className);
    }
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
