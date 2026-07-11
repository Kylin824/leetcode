package org.example.hot100_v2.medium.heap;

import java.util.*;

/**
 * 数组前K个高频元素
 * @author kylin
 * @date 2026/7/9
 *
 * 堆排序、优先队列
 */

public class _347 {

    // map (数字 -> 出现次数)
    static Map<Integer, Integer> map = new HashMap<>();

    public static int[] topKFrequent1(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 对出现次数做堆排
        int[] heap = new int[k]; // k个值的小根堆
        int i = 0;

        // 建一个长度为k的堆
        for (Integer key : map.keySet()) {
            if (i < k) {
                heap[i] = key;
                i++;
                if (i == k) {
                    // 调整为小根堆
                    for (int j = k / 2 - 1; j >= 0; j--) {
                        heapAdjust(heap, j, k);
                    }
                }
            } else {
                // 依次比较堆顶，比堆顶大则替换并重建堆
                Integer count = map.get(key);
                if (count > map.get(heap[0])) {
                    heap[0] = key;
                    heapAdjust(heap, 0, k);
                }
            }
        }
        return heap;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapAdjust(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        // 左节点小于当前节点
        if (left < n && map.get(arr[left]) < map.get(arr[i])) {
            min = left;
        }
        // 右节点小于当前节点
        if (right < n && map.get(arr[right]) < map.get(arr[min])) {
            min = right;
        }
        // 子节点提到根节点位置，从子节点重新调整
        if (min != i) {
            swap(arr, min, i);
            heapAdjust(arr, min, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2))); // [1,2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,2,3,2,3,3,3,3}, 2))); // [2,3]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{5,2,5,3,5,3,1,1,3}, 2))); // [3,5]

    }

    public static int[] topKFrequent(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer i : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (map.get(i) > map.get(queue.peek())) {
                queue.poll();
                queue.offer(i);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
