package cn.stream.streambuilder.construct;

import cn.stream.streambuilder.construction.flow.ObjectFile;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

public class RefectClassLoader {
    public static void main(String[] args) throws Exception {
          Path rootLocation;
        rootLocation = Paths.get(STORAGEPATH);
//        System.out.println(sb.toString());
//
        File filpath=new File("");
        String path = "file:"+filpath.getAbsoluteFile()+"\\"+STORAGEPATH+"\\";
        System.out.println(path);
//        System.out.println(filpath.getAbsoluteFile());
        URL newurl=new URL(path);
//        String classname =ObjectFile.getClassName("test");

        URLClassLoader classLoader=new URLClassLoader(new URL[]{newurl});
//        Class<?> methtClass = classLoader.loadClass("classMappers."+classname);
//        Object obj = methtClass.newInstance();
//        methtClass.getDeclaredMethod("timeee").invoke(obj);
//        System.out.println(classLoader);

    }

}
