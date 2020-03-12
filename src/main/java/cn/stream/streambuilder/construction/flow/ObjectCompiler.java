package cn.stream.streambuilder.construction.flow;


import cn.stream.streambuilder.exception.ClassCharSetIllegalException;
import lombok.extern.slf4j.Slf4j;

import javax.tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

@Slf4j
public class ObjectCompiler {

    /*
    *   这里原本是根据文件以java to class的方法,由于需要读取文件的原因,所以取消掉
    *   改成了使用内存编译的方式
     */
    public static void CompilerJava(String className, String serial) throws Exception {
        String filePath = STORAGEPATH+"\\"+serial+"\\"+className+".java";
        String targetDir = STORAGEPATH+"\\"+serial+"\\class";

        Path targetLocation = Paths.get(targetDir);
        Path javaFile = Paths.get(filePath);
        try {
            Files.createDirectories(targetLocation);
        } catch (IOException e) {
            log.info("目录已经存在");
        }
//        String javaFile = filePath+className+".java";
        FileWriter fw = new FileWriter(filePath);

        // 获取编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 获取标准文件管理器实例
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        try {

            // 获取要编译的编译单元
            Iterable<String> options = Arrays.asList("-encoding", "UTF-8", "-classpath", null, "-d", targetDir, "-sourcepath", filePath);
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            Iterable<? extends JavaFileObject> compilationUnits1  = fileManager.getJavaFileObjects(javaFile);
            JavaCompiler.CompilationTask compilationTask = compiler.getTask(fw, fileManager, null,options,null, compilationUnits1);
            // 运行编译任务
            //需要修改jdk lib位置
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();

             compilationTask.call();
        } finally {
            fileManager.close();
        }




//        String basePath = STORAGEPATH+"\\"+serial+"\\";
//        String javaFile = basePath+className+".java";
//        FileWriter fw = new FileWriter(javaFile);
//        fw.flush();
//        fw.close();
//
//        // 编译
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
//        Iterable<? extends JavaFileObject> compilationUnits1  = fileManager.getJavaFileObjects(javaFile);
//        JavaCompiler.CompilationTask task = compiler.getTask(fw, fileManager, null, null, null, compilationUnits1 );
//        task.call();
//        fileManager.close();
//
//
//        // 加载运行 ClassLoader只能加载bin目录下的class文件
//        URL[] urls = new URL[] {new URL("file:"+basePath)};
//        URLClassLoader ucl = new URLClassLoader(urls);
//
//
//        Class<?> clazz = ucl.loadClass(className);
////        Class<?> methtClass = classLoader.loadClass("classMappers."+className);
//        Object obj = clazz.newInstance();
//            clazz.getDeclaredMethod("timeee").invoke(obj);
////        System.out.println(classLoader);
//
////        Constructor<?> constructor = clazz.getDeclaredConstructor(java.lang.String.class);
////        Object instance = constructor.newInstance("111");

    }
    public static void inMemoryCompiler(){

        Map<String, byte[]> results;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);
//        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
//            JavaFileObject javaFileObject = manager.makeStringSource(fileName, source);
//            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, Arrays.asList(javaFileObject));
//            if (task.call()) {
//                results = manager.getClassBytes();
//            }
//        }



    }

}
