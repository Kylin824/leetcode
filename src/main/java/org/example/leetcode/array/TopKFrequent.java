package org.example.leetcode.array;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequentPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            }
            else if (map.get(key) > map.get(pq.peek())){
                pq.poll();
                pq.add(key);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.remove();
            i++;
        }
        return res;
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequentHeap(int[] nums, int k) {
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] heap = new int[k];
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i < k) {
                // 填充数据
                heap[i] = key;
                i++;
                if (i == k){
                    // 数据填满，调整为小根堆
                    for (int j = k / 2 - 1; j >= 0; j--) {
                        minHeapAdjust(heap, j);
                    }
                    i++;
                }
            }
            else {
                // 小根堆已建好，对每个元素与堆顶比较，比堆顶大则替换堆顶，重新调整小根堆
                if (map.get(key) > map.get(heap[0])) {
                    heap[0] = key;
                    minHeapAdjust(heap, 0);
                }
            }
        }
        return heap;
    }

    public void minHeapAdjust(int[] heap, int i) {
        int tmp = heap[i];
        for (int j = 2 * i + 1; j < heap.length; j = 2 * j + 1) {
            if (j + 1 < heap.length && map.get(heap[j]) > map.get(heap[j + 1]))
                j++;  // 指向左右节点小的节点
            if (map.get(heap[j]) < map.get(heap[i])) {
                // 指向的小节点比根节点更小
                heap[i] = heap[j];
                i = j;
            }
            else
                break;
            heap[i] = tmp;
        }
    }

    public static void main(String[] args) {
        TopKFrequent tk = new TopKFrequent();

        int[] test = {4,1,-1,2,-1,2,3};
        int[] res = tk.topKFrequentHeap(test, 2);
        System.out.println(Arrays.toString(res));
    }
}
