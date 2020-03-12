package cn.stream.streambuilder.construction.flow;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cn.stream.streambuilder.config.Constant.STORAGEPATH;

public class ObjectCompiler {
    public static void CompilerJava(String className,String serial) throws Exception {
//        // 获取编译器实例
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        // 获取标准文件管理器实例
//        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
//        try {
//            if (!isnull(filePath) && !isnull(sourceDir) && !isnull(targetDir)) {
//                return false;
//            }
//            // 得到filePath目录下的所有java源文件
//            File sourceFile = new File(filePath);
//            List<File> sourceFileList = new ArrayList<File>();
//            this.targetDir = targetDir;
//            getSourceFiles(sourceFile, sourceFileList);
//            // 没有java文件，直接返回
//            if (sourceFileList.size() == 0) {
//                System.out.println(filePath + "目录下查找不到任何java文件");
//                return false;
//            }
//            // 获取要编译的编译单元
//            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
//            /**
//             * 编译选项，在编译java文件时，编译程序会自动的去寻找java文件引用的其他的java源文件或者class。 -sourcepath选项就是定义java源文件的查找目录， -classpath选项就是定义class文件的查找目录。
//             */
//            Iterable<String> options = Arrays.asList("-encoding", encoding, "-classpath", jars, "-d", targetDir, "-sourcepath", sourceDir);
//            JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits);
//            // 运行编译任务
//            return compilationTask.call();
//        } finally {
//            fileManager.close();
//        }
















        String basePath = STORAGEPATH+"\\"+serial+"\\";
        String javaFile = basePath+className+".java";
        FileWriter fw = new FileWriter(javaFile);
        fw.flush();
        fw.close();

        // 编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits1  = fileManager.getJavaFileObjects(javaFile);
        JavaCompiler.CompilationTask task = compiler.getTask(fw, fileManager, null, null, null, compilationUnits1 );
        task.call();
        fileManager.close();


        // 加载运行 ClassLoader只能加载bin目录下的class文件
        URL[] urls = new URL[] {new URL("file:"+basePath)};
        URLClassLoader ucl = new URLClassLoader(urls);


        Class<?> clazz = ucl.loadClass(className);
//        Class<?> methtClass = classLoader.loadClass("classMappers."+className);
        Object obj = clazz.newInstance();
            clazz.getDeclaredMethod("timeee").invoke(obj);
//        System.out.println(classLoader);

//        Constructor<?> constructor = clazz.getDeclaredConstructor(java.lang.String.class);
//        Object instance = constructor.newInstance("111");

    }

}
