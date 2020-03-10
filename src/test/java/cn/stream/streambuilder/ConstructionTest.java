package cn.stream.streambuilder;

import cn.stream.streambuilder.construction.file.ObjectFile;

import javax.tools.JavaFileObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ConstructionTest {
    public static void main(String[] args) throws Exception {

        ObjectFile.classMapperBuild("test");

//        System.out.println(Class.forName("java.lang.String").newInstance());
//
//        System.out.println(Class.forName("java.lang.String").getConstructors()
//                [11].newInstance("reflect"));
//
//        System.out.println(Proxy.newProxyInstance(null, new Class[]
//                        {Class.forName("java.lang.Comparable")},
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args)
//                    {
//                        System.out.println(method);
//                        System.out.println("Proxy");
//                        return "toString";
//                    }
//                }));
    }

}
