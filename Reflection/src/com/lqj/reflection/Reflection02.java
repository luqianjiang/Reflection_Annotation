package com.lqj.reflection;

import com.lqj.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author luqianjiang
 * @Date 2023/3/12 17:57
 * @Description:
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {

        //Field
        //Method
        //Constructor
        m1();
        m2();
        //m3();
    }

    //传统方法来调用hi
    public static void m1() {

        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1() 耗时=" + (end - start));
    }

    //反射机制调用方法hi
    public static void m2() throws Exception {

        Class cls = Class.forName("com.lqj.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时=" + (end - start));
    }

}
