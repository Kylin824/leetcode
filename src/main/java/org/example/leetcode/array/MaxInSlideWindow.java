package org.example.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlideWindow {
    /*
    滑动窗口的最大值
    给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

    示例:

    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    输出: [3,3,5,5,6,7]

    双端队列 存索引
    左端存最大值的索引
    遍历，对于每个num[i]
        1. num[i]比队列右端索引对应的值大，右端一直出队直到比num[i]大或者为空，num[i]的索引i入队
        2. num[i]比队列右端索引对应的值小，num[i]的索引i入队

    如果队列左端最大值索引失效(<=i-size) 则左端索引出队
    如果i索引超过size-1 则开始添加每个窗口最大值
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>(); // 非递减
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0]  = deque.peekFirst();
        // deque最左端存最大值
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (deque.peekFirst() == nums[i - 1]) { // 当前窗口最大值被移出
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i + k - 1]) { // 窗口右端的值进入deque
                deque.removeLast();
            }
            deque.addLast(nums[i + k - 1]);
            res[i]  = deque.peekFirst();
        }
        return res;
    }
}
