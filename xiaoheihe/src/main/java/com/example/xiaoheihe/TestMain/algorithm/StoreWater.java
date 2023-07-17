package com.example.xiaoheihe.TestMain.algorithm;

import java.util.Arrays;

public class StoreWater {
    public static void main(String[] args) {
        int operTimes = new StoreWater().doStoreWater(new int[]{9,0,1}, new int[]{0,2,2});
        System.out.println(String.format("共需要操作%d次",operTimes));
    }


    public int doStoreWater(int[] bucket, int[] vat) {
        int storeTimes = 0;
        int j = 0;
        int temp;
        for(int i = 0; i < bucket.length; i++){
            if (vat[i] == 0){
                continue;
            }
            if (i == 0){
                storeTimes = (int)Math.ceil((double)vat[i]/bucket[i]);
                continue;
            }
            temp = (int)Math.ceil((double)vat[i]/bucket[i]);
            if(temp < storeTimes){
                storeTimes = temp;
                j = i;
            }
        }

        //升级
        int operTimes = 0;
        int[] levelTimes = new int[bucket.length];
        for(int i = 0; i < bucket.length; i++){
            if(i == j || vat[0] == 0){
                continue;
            }
            levelTimes[i] = (int)Math.ceil((double)vat[i]/storeTimes) - bucket[i];
            System.out.println(String.format("第%d个桶,升级%d次", i + 1, levelTimes[i]));
        }
        int levelSum = Arrays.stream(levelTimes).sum();
        System.out.println(String.format("共需要升级%d次",levelSum));
        System.out.println(String.format("共需要蓄水%d次",storeTimes));
        operTimes = levelSum + storeTimes;
        return operTimes;
    }
}
