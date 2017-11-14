package me.tony.practice.lombok;

import lombok.val;

public class Main {

    public static void main(String[] args) {
        val foo = new MyBean();
        foo.setName("haha");
        System.out.println(foo);

    }
}
