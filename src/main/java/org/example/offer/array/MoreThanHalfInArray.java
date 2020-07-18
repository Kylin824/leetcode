package org.example.offer.array;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfInArray {
    /*
        NO.28
        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
        例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
        由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    /*
        思路:
            1. map计数后统计

            2. 利用数量超过一半的特点：消去法，如果超过一半，则消去后最终只留下这个数
     */
    public static int MoreThanHalfNum_Solution1(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            }
            else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > array.length / 2)
                return i;
        }
        return 0;
    }

    public static int MoreThanHalfNum_Solution2(int [] array) {
            int condition = -1;
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (count == 0) {
                    condition = array[i];
                    count++;
                }
                else {
                    if (condition == array[i])
                        count++;
                    else
                        count--;
                }
            }
            // 遍历一遍确认剩下的condition是否为众数
            count = 0;
            for (int i : array) {
                if (condition == i)
                    count++;
            }
            if (count > array.length / 2)
                return condition;
            return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution2(arr));
    }
}
