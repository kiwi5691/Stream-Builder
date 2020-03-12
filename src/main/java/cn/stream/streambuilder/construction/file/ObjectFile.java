package cn.stream.streambuilder.construction.file;

import cn.stream.streambuilder.exception.ClassCharSetIllegalException;
import cn.stream.streambuilder.web.base.JacksonUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

@Slf4j
public class ObjectFile {


    public static Path rootLocation;

    public static List classCharSetTsList(String charSetContent){
        String content = charSetContent;

        try {
            List idList = Arrays.asList(content.split("\n"));
            return idList;
        }catch (Exception e){
            throw new ClassCharSetIllegalException();
        }

    }


    public static void readWrite(List content,String serial) throws Exception {
        Charset utf8 = StandardCharsets.UTF_8;

        rootLocation = Paths.get(STORAGEPATH);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        try {
            Files.write(Paths.get(rootLocation+"\\"+serial+".java"), content, utf8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        String outFileName = "classMappers\\";
//
//        Path readPath = Paths.get(file.getPath());
//        Path writePath = Paths.get(outFileName);
        //copy文件
//                Files.copy(readPath, writePath);
        //读取文件
//        Files.write(writePath, Files.readAllBytes(readPath));
    }
    public static String getClassName(String fileName) throws Exception {
        final String space="";
        final String suffix="{";

        final String ClassSuffix ="public class";
        Path rootLocation;
        rootLocation = Paths.get(STORAGEPATH);
        List<String> lines = Files.readAllLines(Paths.get(STORAGEPATH+"/"+fileName), StandardCharsets.UTF_8);
        String className ="";

        Integer counter =0;

        for (String line: lines) {
            counter++;
            if(line.startsWith(ClassSuffix)) {
                className = line;
                break;
            }
        }
        if(counter.equals(lines.size())){
            throw new ClassCharSetIllegalException();
        }
        className =className.substring(ClassSuffix.length(),className.length());
        String[] strsplit = className.split(" ");

        for (int j = 0; j< strsplit.length; j++) {
            if(!strsplit[j].equals(space)&&!strsplit[j].equals(suffix)){
                return strsplit[j];//
            }
        }
        return "";
    }

    public static void main(String[] args) throws Exception {
//        readWrite(new File("D:\\11G.rar"));
//        readWriteUtils(new File("D:\\2.jpg"));
    }
}
