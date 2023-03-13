package com.lqj.reflection.class_;

import com.lqj.Cat;

/**
 * @Author luqianjiang
 * @Date 2023/3/12 20:12
 * @Description:
 */
public class Class01 {
    public static void main(String[] args) throws Exception {
        //看看Class类  Class也是类，因此也继承Object类
        //Class类对象不是new出来的，而是系统创建的


        //(1) 传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();


        //(2) 反射方式, 刚才没有debug到 ClassLoader类的 loadClass, 原因是没有注销Cat cat = new Cat();
        /*
            ClassLoader类, 仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("com.lqj.Cat");

        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        Class cls2 = Class.forName("com.lqj.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode()); // hashCode一致
    }
}
