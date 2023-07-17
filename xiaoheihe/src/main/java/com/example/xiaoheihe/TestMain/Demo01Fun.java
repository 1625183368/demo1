package com.example.xiaoheihe.TestMain;

import org.springframework.util.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;

public class Demo01Fun {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

//        fun2((arr)->{
//            int del = arr[0];
//            for(int i = 1; i < arr.length; i++){
//                del -= arr[i];
//            }
//            return del;
//        });
//        List<? extends Parent> p1 = new ArrayList<>();
//        List objects = new ArrayList<>();
//        Parent p = new Son();
//        Grandpa g = new Grandpa();
//        objects.add(p);
//        objects.add(g);

//        p1.add(p);
//        p1.add(g);
//        p1.addAll(objects);
//        System.out.println(p1);
//
//        pfun(msg-> msg.length() > 8,"yesorNo");
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime with = now.with(TemporalAdjusters.());
//        System.out.println(with);

//        List<String> list = Arrays.asList("1287asd","343", "1231", "avf" ,"1");
//        list.sort((o1, o2) -> new Comp().compare(o1, o2));
//        list.forEach(f-> System.out.println(f+"\t"));
//        System.out.println();

//        list.stream().filter(f->f.contains("a")).findAny().orElse("s");
//        System.out.println(list.stream().filter(f->f.contains("ppp")).findAny().orElse("no"));
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Parent parent = new Parent();

        parent.setName("testName");
        System.out.println(parent);
        refectFun1(parent);
        System.out.println(parent);
    }

    public static <T> void refectFun1(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = t.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
//        for (Method method : declaredMethods){
//
//        }
        if (declaredFields.length > 0){
            for (Field field : declaredFields){
                field.setAccessible(true);
                if (field.getType().getSimpleName().equals("String")){
                    Method method = aClass.getMethod("set" + StringUtils.capitalize(field.getName()),String.class);
                    method.invoke(t,"refectString");
                }
            }
        }
    }


    public static void fun1(Operator operator1,Operator operator2){
        int[] arr = {1,2,3,4};
//        int sum = operator1.getSum(arr);
        int sum1 = operator1.andThen(operator2).getSum(arr);
        System.out.println("sum = /n" + sum1);
    }

    public static void pfun(Predicate<String> predicate,String msg){
        boolean test = predicate.test(msg);
        System.out.println(test);
    }

    public static void fun2(OperatorDel del){
        int[] arr = {10,5,3};
        int delDel = del.getDel(arr);
        System.out.println(delDel);
    }

    public static void fun3(Parent... parents){
        for (Parent p : parents){
            System.out.println(p);
        }
    }
}


class Comp implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if (o1.contains(o2)) {
            return 0;
        }else return -1;
    }
}

class Parent extends Grandpa{
    String name = "parent";
    Integer age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Son extends Parent{

}

class Grandpa{
    String name = "grandpa";

    @Override
    public String toString() {
        return "Grandpa{" +
                "name='" + name + '\'' +
                '}';
    }
}

interface OperatorDel{
    int getDel(int[] arr);
}

/**
 * 函数式接口
 */
@FunctionalInterface
interface Operator{


    int getSum(int[] arr);

    default Operator andThen(Operator operator){
        System.out.println("andThen 计算中");

        return operator;
    }
}



