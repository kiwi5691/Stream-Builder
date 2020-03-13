package cn.stream.streambuilder.construction.flow.compiler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class JavaStringCompiler {
    JavaCompiler compiler;
    //// 获取标准文件管理器实例
    StandardJavaFileManager stdManager;

    public JavaStringCompiler() {
        this.compiler = ToolProvider.getSystemJavaCompiler();
        this.stdManager = compiler.getStandardFileManager(null, null, null);
    }


    //source 为原class的字符串类型
    public Map<String, byte[]> compile(String fileName, String source) throws IOException {
        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
            //通过构造SimpleJavaFileObject到CharBuffer缓冲池中
            JavaFileObject javaFileObject = manager.makeStringSource(fileName, source);
            //开始编译
            CompilationTask task = compiler.getTask(null, manager, null, null, null, Arrays.asList(javaFileObject));
            Boolean result = task.call();
            //验证是否编译成功
            if (result == null || !result.booleanValue()) {
                //throw new RuntimeException("Compilation failed.");
                throw new ClassCastException();
            }
            //这里返回
            return manager.getClassBytes();
        }
    }




    public Class<?> loadClass(String name, Map<String, byte[]> classBytes) throws ClassNotFoundException, IOException {
        //这里封装了URLClassLoader
        try (MemoryClassLoader classLoader = new MemoryClassLoader(classBytes)) {
            return classLoader.loadClass(name);
        }catch (Exception e){
            throw new ClassCastException();
        }
    }
}
