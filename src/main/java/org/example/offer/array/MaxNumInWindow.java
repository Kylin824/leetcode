package org.example.offer.array;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxNumInWindow {
    /*
        NO.64
        给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
        例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
        他们的最大值分别为{4,4,6,6,6,5}；
        针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
        {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
        {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */
    /*
        思路:
            1. 暴力

            2. 双端队列 存索引
                左端存最大值的索引
                遍历，对于每个num[i]
                    1. num[i]比队列右端索引对应的值大，右端一直出队直到比num[i]大或者为空，num[i]的索引i入队
                    2. num[i]比队列右端索引对应的值小，num[i]的索引i入队

                如果队列左端最大值索引失效(<=i-size) 则左端索引出队
                如果i索引超过size-1 则开始添加每个窗口最大值

     */

    public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0 || num.length <= 0)
            return res;
        for (int i = 0; i < num.length - size + 1; i++) {
            int min = num[i];
            for (int j = i; j < i + size; j++) {
                if (num[j] > min)
                    min = num[j];
            }
            res.add(min);
        }
        return res;
    }

    public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0 || num.length <= 0)
            return res;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 如果num[i]大于num[i-1]、num[i-2]、...  则num[i-1]无效 直接poll
            // 如果num[i]小于num[i-1]、num[i-2]、...  则num[i-1]保留
            while (!list.isEmpty() && num[list.peekLast()] < num[i])
                list.pollLast();

            list.offer(i); // 存索引

            // 判断左边最大值是否失效
            if (list.peekFirst() <= i - size)
                list.pollFirst();

            // 从第size-1个数开始统计最大值
            if (i >= size - 1)
                res.add(num[list.peekFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> res = maxInWindows1(arr, 3);
    }
}
