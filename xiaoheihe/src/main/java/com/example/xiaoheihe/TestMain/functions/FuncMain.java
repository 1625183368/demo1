package com.example.xiaoheihe.TestMain.functions;

import java.util.function.Function;

public class FuncMain {
    public static void main(String[] args) {
        convert("100", s -> Integer.parseInt(s));
        convert("100", Integer::parseInt);

        convert(100, i -> String.valueOf(100 + i));

        convert("100", s -> Integer.parseInt(s), i -> String.valueOf(i + 566));

    }

    //定义一个方法，把一个int类型的数据加上一个整数之后，转为字符串在控制台输出
    private static void convert(String s, Function<String, Integer> function) {
        Integer i = function.apply(s);
        System.out.println(i);
    }

    //定义一个方法，把一个int类型的数据加上一个整数之后，转为字符串在控制台输出
    private static void convert(int i, Function<Integer, String> function) {
        String s = function.apply(i);
        System.out.println(s);
    }

    //定义一个方法，把一个字符串转换为int类型，把int类型的数据加上一个整数之后，转为字符串在控制台输出
    private static void convert(String s, Function<String, Integer> function1, Function<Integer, String> function2) {
        String ss = function2.apply(function1.apply(s));
        System.out.println(ss);
    }
}
