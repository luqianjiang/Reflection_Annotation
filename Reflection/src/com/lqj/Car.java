package com.lqj;

/**
 * @Author luqianjiang
 * @Date 2023/3/12 21:07
 * @Description:
 */
public class Car {
    public String brand = "宝马";//品牌
    public int price = 500000;
    public String color = "白色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
