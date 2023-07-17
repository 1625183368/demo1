package com.example.xiaoheihe.TestMain.algorithm;

public class BiSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,9};
        System.out.println(biSearch(arr,6));
    }

    public static int biSearch(int[] array,int a) {
        int min = 0;
        int max = array.length - 1;
        int mid;
        while(min < max){
            mid = (min + max)/2;
            if (array[mid] == a){
                return mid + 1;
            }else if(array[mid] < a){
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        return -1;
    }
}
