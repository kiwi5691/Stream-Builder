package cn.stream.streambuilder.construction.flow;

import cn.stream.streambuilder.exception.ClassCharSetIllegalException;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
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


    public static String readWrite(List content,String serial) throws Exception {
        Charset utf8 = StandardCharsets.UTF_8;

        //todo TEST
        rootLocation = Paths.get(STORAGEPATH+"\\"+serial);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        try {
            String className =getClassName(content);
            if(className.equals("")){
               throw new ClassCharSetIllegalException();
            }
            Files.write(Paths.get(rootLocation+"\\"+className+".java"), content, utf8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return className;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static String getClassName(List<String> lines) throws Exception {
        final String space="";
        final String suffix="{";

        final String ClassSuffix ="public class";
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

}
