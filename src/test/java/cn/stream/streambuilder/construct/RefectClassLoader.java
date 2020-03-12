package cn.stream.streambuilder.construct;

import cn.stream.streambuilder.construction.file.ObjectFile;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

public class RefectClassLoader {
    public static void main(String[] args) throws Exception {
          Path rootLocation;
        rootLocation = Paths.get(STORAGEPATH);
//        System.out.println(sb.toString());
//
        File filpath=new File("");
        String path = "file:"+STORAGEPATH+"728725cb-c27c-5e0e-a717-a441b93d56fd.java";
        URL newurl=new URL(path);
        String classname =ObjectFile.getClassName("728725cb-c27c-5e0e-a717-a441b93d56fd.java");
        URLClassLoader classLoader=new URLClassLoader(new URL[]{newurl});
        Class<?> methtClass = classLoader.loadClass(classname);
        Object obj = methtClass.newInstance();
        methtClass.getDeclaredMethod("timeee").invoke(obj);
        System.out.println(classLoader);

    }

}
