package com.gaaloeng.myclass;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Properties;

public class ClassTest {
    @Test
    public void myClassTest() throws IOException ,InstantiationException{
        //获取一个当前类的类加载器
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        //使用类加载器加载一个propertise文件
        InputStream resourceAsStream = classLoader.getResourceAsStream("JDBC.properties");

        //加载资源文件
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }



    @Test
    public void getFieldsTest(){
        Class<Person> personClass = Person.class;
        //getFileds:获取该类的每个public的field(包括父类的public field)
        Field[] fields = personClass.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }

        System.out.println();

        //获取运行时类的各个field(所有权限的field都能获取)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field:declaredFields) {
            System.out.println(field);
            //getName():获取field的名字
            System.out.print(field.getName()+"\t");
            //getType():获取field的类型
            System.out.print(field.getType()+"\t");
            //getModifiers():获取field的权限 ; Modifier.toString():把数字表示的权限转换成字符形式(private,deafault,product,publuic)
            int modifiers = field.getModifiers();
            String s = Modifier.toString(modifiers);
            System.out.print(s);

            System.out.println();
        }
    }

    @Test
    public void getMethodsTest() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("com.gaaloeng.myclass.Person");
        //getFileds:获取该类的每个public的method(包括父类的public method)
        Method[] methods = personClass.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }

        System.out.println();

        //获取运行时类的各个method(所有权限的method都能获取)
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method:methods) {
          //  System.out.println(method);
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation: annotations) {
                System.out.println(annotation);
            }
        }
    }

    @Test
    public void getConstructorsTest() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        //获取所有public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //获取所有权限的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor constructor:declaredConstructors) {
            System.out.println(constructor);
        }
        System.out.println();
    }

    @Test
    public void getSuperClassTest(){
        Class<Person> personClass = Person.class;
        //获取运行时类的父类
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    public void TestgeField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        //获取指定的属性,要求类中属性声明为public
        Field name = personClass.getField("name");
        //创建运行时类的对象
        Person person = personClass.newInstance();
        /*
            设置当前属性的值
            set(参数1,参数2):参数1,实名设置哪了类的对象;参数2,将此属性值设置为多少
         */
        name.set(person,"小明");

        /*
            获取当属性的值
            get(参数1):参数1,获取哪个对象的当前属性值
         */
        System.out.println(name.get(person));
        System.out.println();

        //获取一个私有属性
        Field age = personClass.getDeclaredField("age");
        //设置当前属性可访问
        age.setAccessible(true);
        //对属性进行操作
        age.set(person,20);
        System.out.println(age.get(person));

    }

    @Test
    public void testGetDeclaredMethod() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        /*
        1.获取指定的某个方法
        getDeclaredMethod(参数1,参数2) 参数1 指明获取的方法的名称;参数2 指明获取方法的参数列表
        */
        Method show = personClass.getDeclaredMethod("show", int.class);
        /*
        2.设置方法的权限
        */
        show.setAccessible(true);
        /*
        3.invoke():参数1 方法的调用者;参数2 给方法形参赋值的实参
        invoke()的返回值就是被调用方法的返回值
        */
        Object invokeValue = show.invoke(person,18);

        System.out.println(invokeValue);
    }

    @Test
    public void testGetConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Person person = declaredConstructor.newInstance();


    }
}
