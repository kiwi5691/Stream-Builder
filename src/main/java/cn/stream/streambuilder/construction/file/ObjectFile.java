package cn.stream.streambuilder.construction.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ObjectFile {

    /**
     * nio 使用普通方式 读取加载到缓存中
     **/
    public static void readWrite(File file) throws Exception {
        //读取文件
        FileInputStream readFile = new FileInputStream(file);
        //写入文件
        FileOutputStream outFile = new FileOutputStream("D:\\fuck.rar");
        //获取通道
        FileChannel readChannel = readFile.getChannel();
        FileChannel outChannel = outFile.getChannel();

        // 3. 创建缓冲区对象
        ByteBuffer buff = ByteBuffer.allocate(1024);
        while (true) {
            int readNumber = readChannel.read(buff);
            if (readNumber == -1) {
                break;
            }
            // 5. 传出数据准备：调用flip()方法
            buff.flip();

            // 6. 从 Buffer 中读取数据 & 传出数据到通道
            outChannel.write(buff);

            // 7. 重置缓冲区
            buff.clear();
        }
    }


    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
//    public Attachments store(InputStream inputStream, long contentLength, String contentType, String fileName) {
//        String key = generateKey(fileName);
//        storage.store(inputStream, contentLength, contentType, key);
//
//        String url = generateUrl(key);
//        Attachments storageInfo = new Attachments();
//        storageInfo.setName(fileName);
//        storageInfo.setSize((int) contentLength);
//        storageInfo.setType(contentType);
//        storageInfo.setKey(key);
//        storageInfo.setUrl(url);
//        baseStorageService.add(storageInfo);
//
//        return storageInfo;
//    }
    public static void classMapperBuild(String className) throws Exception {
        Path newFile = FileSystems.getDefault().getPath("\\classMappers\\"+className+".java");
        Files.createFile(newFile);
        System.out.println("File created successfully!");
    }
        /**
         * nio 读取文件 使用File和Path工具
         */
    public static void readWriteUtils(File file) throws Exception {
        String outFileName = "classMappers\\";

        Path readPath = Paths.get(file.getPath());
        Path writePath = Paths.get(outFileName);
        //copy文件
//                Files.copy(readPath, writePath);
        //读取文件
        Files.write(writePath, Files.readAllBytes(readPath));
    }


    public static void main(String[] args) throws Exception {
//        readWrite(new File("D:\\11G.rar"));
        readWriteUtils(new File("D:\\2.jpg"));
    }
}
