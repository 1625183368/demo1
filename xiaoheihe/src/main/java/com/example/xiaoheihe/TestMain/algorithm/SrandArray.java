package com.example.xiaoheihe.TestMain.algorithm;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class SrandArray {

    public static int[] srand(int[] a){
        int []b = new int[a.length];
        for (int i = 0; i < a.length; i++){
            int index = (int) (Math.random()*(a.length - i));

            b[i] = a[index];
            //处理过的数据保存到最后面
            int temp = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[index];
            a[index] = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(srand(a)));
    }
}
