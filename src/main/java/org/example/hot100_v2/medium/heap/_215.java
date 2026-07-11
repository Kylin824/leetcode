package org.example.hot100_v2.medium.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中第 k 个最大的元素
 * @author kylin
 * @date 2026/7/11
 *
 * 堆排序、优先队列
 */

public class _215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num > queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        _215 obj = new _215();
        System.out.println(obj.findKthLargest(new int[]{1,2,3,4,5,6,7,8,9}, 3));;
    }

}
