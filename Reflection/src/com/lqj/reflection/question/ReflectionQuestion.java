package com.lqj.reflection.question;

import com.lqj.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author luqianjiang
 * @Date 2023/3/12 15:43
 * @Description: 反射问题的引入
 */
public class ReflectionQuestion {

    public static void main(String[] args) throws Exception {

        //传统的方式 new 对象 -》 调用方法
        Cat cat = new Cat();
        cat.hi(); // cat.cry() 修改源码.

        //2. 使用Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\workspace_idea\\Reflection_Annotation\\Reflection\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.lqj.Cat"
        String methodName = properties.get("method").toString();//"hi"
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + methodName);

        //创建对象 , 传统的方法，行不通 =》 反射机制
        //new classfullpath();

        //3. 使用反射机制解决
        //(1) 通过类路径加载类, 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.hspedu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 com.hspedu.Cat 的 methodName"hi"  的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)
}
}
