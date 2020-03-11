package cn.stream.streambuilder.construction.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

@Slf4j
public class ObjectFile {

    public static Path rootLocation;


    public static void classMapperBuild(String className) throws Exception {
        Path newFile = FileSystems.getDefault().getPath("\\classMappers\\"+className+".java");
        Files.createFile(newFile);
        System.out.println("File created successfully!");
    }

    public static void readWrite(String className) throws Exception {
        rootLocation = Paths.get(STORAGEPATH);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        Files.createFile(Paths.get(rootLocation+"\\"+className+".java"));
//        String outFileName = "classMappers\\";
//
//        Path readPath = Paths.get(file.getPath());
//        Path writePath = Paths.get(outFileName);
        //copy文件
//                Files.copy(readPath, writePath);
        //读取文件
//        Files.write(writePath, Files.readAllBytes(readPath));
    }


    public static void main(String[] args) throws Exception {
//        readWrite(new File("D:\\11G.rar"));
//        readWriteUtils(new File("D:\\2.jpg"));
    }
}
