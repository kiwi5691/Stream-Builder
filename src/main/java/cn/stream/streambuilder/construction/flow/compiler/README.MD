### 具体使用在同级reflect包下的ClassOperation

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

