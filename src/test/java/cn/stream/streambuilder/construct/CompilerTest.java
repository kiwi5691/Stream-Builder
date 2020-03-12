package cn.stream.streambuilder.construct;

import cn.stream.streambuilder.construction.flow.ObjectCompiler;
import cn.stream.streambuilder.construction.flow.compiler.JavaStringCompiler;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

public class CompilerTest {

    public static void main(String[] args) throws Exception {

        final String space="";
        final String SERIAL="8afd2f11-b695-595d-b0f7-5a85a7834cdb";
        final String suffix="{";

        final String ClassSuffix ="public class";
        Path rootLocation;
        rootLocation = Paths.get(STORAGEPATH+"\\"+SERIAL);
        List<String> lines = Files.readAllLines(Paths.get(rootLocation+"\\Logs.java"), StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line: lines) {
            stringBuilder.append(line);
        }

        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> results = compiler.compile("Logs.java", stringBuilder.toString());
        Class<?> clazz = compiler.loadClass("Logs", results);
        Object obj = clazz.newInstance();
        clazz.getDeclaredMethod("timeee").invoke(obj);
        // try instance:
    }
}
