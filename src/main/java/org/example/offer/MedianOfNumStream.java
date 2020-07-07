package org.example.offer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfNumStream {
    /*
        NO.63
        对动态数据流求中位数。
     */
    /*
        思路:
            左边用大根堆，右边用小根堆，同时保持左右数量相差不超过1
     */

    int count = 0;
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((x, y) -> y - x); // 转成大根堆 在左边
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>(); // 默认小顶堆  在右边


    public void Insert(Integer num) {
        count++;
        leftMaxHeap.offer(num); // 新的数加入左边大顶堆
        rightMinHeap.offer(leftMaxHeap.poll()); // 左边弹出一个最大的到右边
        if (count % 2 != 0)
            // 如果两个堆合起来的元素是奇数，右边要拿出最小的元素给到左边成为最大的数，也是奇数时的中位数
            leftMaxHeap.offer(rightMinHeap.poll());

    }

    public Double GetMedian() {
        if (count % 2 == 0)
            // 两个堆合起来是偶数，取各自顶点的平均值
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        else
            return (double)leftMaxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfNumStream ms = new MedianOfNumStream();
        ms.Insert(5);
        System.out.println(ms.GetMedian());
        ms.Insert(7);
        System.out.println(ms.GetMedian());
        ms.Insert(10);
        System.out.println(ms.GetMedian());
    }
}
