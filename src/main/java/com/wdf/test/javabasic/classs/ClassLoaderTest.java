package com.wdf.test.javabasic.classs;

/**
 * @ClassName: ClassLoaderTest
 * @Author WDF
 * @Description 根据类名字，查看类的路径
 * @Date 2020/9/19 11:49
 * @Copyright Dareway 2020/9/19
 * @Version 1.0
 **/
public class ClassLoaderTest {

    // Package-private to allow ClassLoader access
    ClassLoader getClassLoader0() { return classLoader; }

    // Initialized in JVM not by private constructor
    // This field is filtered from reflection access, i.e. getDeclaredField
    // will throw NoSuchFieldException
    private final ClassLoader classLoader;

    private ClassLoaderTest(ClassLoader loader) {
        // Initialize final field for classLoader.  The initialization value of non-null
        // prevents future JIT optimizations from assuming this final field is null.
        classLoader = loader;
    }
    public static void main(String[] args) {
        String name = "package-info.java";
        Class c = ClassLoaderTest.class;
        if (c==null) {
            // A system class.
            System.out.println(ClassLoader.getSystemResource(name));
        }
        System.out.println(c.getResource(name));
    }
}
