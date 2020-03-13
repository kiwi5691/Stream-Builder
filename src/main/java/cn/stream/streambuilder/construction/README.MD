# ObjectFile


将输入的内容存入.java文件中,其中serial是子目录唯一验证id.
前端应该存储好.


# ObjectCompiler

##### 将.java编译为class获取

 动态将java文件编译为class文件.
- 有关java动态编译的API都在javax.tools包中.
- 使用jdk1.6以上版本提供的JavaCompiler工具来动态编译java源文件.
- 通过ToolProvider类的静态方法getSystemJavaCompiler得到JavaCompiler对象实例.
```java
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
```
- 得到JavaCompiler对象实例后,调用该工具的getTask方法获取一个编译任务对象.
```java
方法：getTask(Writer out, JavaFileManager fileManager, DiagnosticListener<? super JavaFileObject> diagnosticListener, Iterable<String> options, Iterable<String> classes, Iterable<? extends JavaFileObject> compilationUnits) 

CompilationTask compilationTask = compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits);

```
- getTask的参数
    1. 文件输出,这里可不指定，采用javac命令的-d参数来指定class文件的生成目录.
    2. 文件管理器实例
```java
// 获取标准文件管理器实例 
StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
该文件管理器实例的作用就是将我们需要动态编译的java源文件转换为getTask需要的编译单元。
// 获取要编译的编译单元 
Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
```
    3. DiagnosticCollector<JavaFileObject> diagnostics是在编译出错时,存放编译错误信息.
    4. 编译命令选项,就是javac命令的可选项,这里我们主要使用了-d和-sourcepath这两个选项.
    5. 类名称
    6. 上面提到的编译单元,就是需要编译的java源文件.
    
- 当得到CompilationTask compilationTask编译任务后,我们就可以调用compilationTask.call()方法进行编译工作.

```java
// 运行编译任务 
compilationTask.call()
```

#### 具体流程

- MemoryClassLoader.java
   1. 创建```java final Map<String, byte[]> classBytes = new HashMap<String, byte[]>();```
   2. MemoryInputJavaFileObject继承于SimpleJavaFileObject，将String的java类型转化为由URL标识的值
   3. MemoryOutputJavaFileObject继承于SimpleJavaFileObject，将String的class类型转化为由URL标识的值
   4. getClassBytes返回classBytes的Map
   
   
- MemoryJavaFileManager.java

    构造于Map<String name,byte[]>,用于加载二进制的class

- JavaStringCompiler.java
    1. 调用MemoryClassLoader的makeStringSource--->MemoryInputJavaFileObject将其被url标识过的java的源文件转化为JavaFileObject
    2. CompilationTask task = compiler.getTask调用后会默认的MemoryClassLoader.getJavaFileForOutput() 自动存入classByte Map中
    3. 通过manager.getClassBytes()返回classBytes Map
    4. loadClass函数调用MemoryJavaFileManager的方法于defineClass加载二进制class

## ClassLoader

ClassLoader的具体作用就是将class文件加载到jvm虚拟机中。
jvm启动的时候，并不会一次性加载所有的class文件，而是根据需要去动态加载。

https://blog.csdn.net/how_interesting/article/details/80091472

## javac

https://segmentfault.com/a/1190000021922361

