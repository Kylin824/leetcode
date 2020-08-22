package org.example.company.kuaishou;

import java.util.HashSet;

public class SequenceNum {
    public static void main(String[] args){
        int[] arr = {100, 5, 77, 4, 88, 6, 7, 8, 99, 33};
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int num = arr[i] - 1;
            while (set.contains(num)) {
                count++;
                num--;
            }
            num = arr[i] + 1;
            while (set.contains(num)) {
                count++;
                num++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
