package com.lqj.reflection;

import java.lang.reflect.Constructor;

/**
 * @Author luqianjiang
 * @Date 2023/3/13 21:19
 * @Description: 演示通过反射机制创建实例
 */
public class ReflecCreateInstance {
    public static void main(String[] args) throws Exception {

        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.lqj.reflection.User");

        //2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        //3. 通过public的有参构造器创建实例
        //3.1 先得到对应构造器
        Constructor<?> constructor = userClass.getConstructor(String.class); //public构造器
        //3.2 创建实例，并传入实参
        Object lqj = constructor.newInstance("lqj");
        System.out.println("lqj=" + lqj);

        //4. 通过非public的有参构造器创建实例
        //4.1 得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //暴破【暴力破解】 , 使用反射可以访问private构造器/方法/属性, 反射面前，都是纸老虎
        constructor1.setAccessible(true);
        Object user2 = constructor1.newInstance(100, "张三丰");
        System.out.println("user2=" + user2);
    }
}

class User { //User类
    private int age = 10;
    private String name = "陆钱江";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}

