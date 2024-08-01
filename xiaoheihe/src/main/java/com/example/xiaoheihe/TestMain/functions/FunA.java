package com.example.xiaoheihe.TestMain.functions;
@FunctionalInterface
interface FunA {
    int a = 1;

    void sayA(int a);

    default void sayAA(){
        System.out.println(FunA.a);
    }

    static void sayAAA(){
        System.out.println("静态方法"+a);
    }


}
