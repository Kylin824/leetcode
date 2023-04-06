package org.example.offer.bst.structure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {9, 25, 42, 33, 27, 51, 46, 38, 24, 10, 11, 13, 15, 21};

        bucketSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1; // 划分桶数量

        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 每个元素根据映射放入对应的桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / arr.length; // 映射关系
            bucketArr.get(num).add(arr[i]);
        }

        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i)); // 对每个桶进行排序
        }

        // 桶中元素赋值到原序列
        int index = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                arr[index] = bucketArr.get(i).get(j);
                index++;
            }
        }
    }
}
