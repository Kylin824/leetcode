package org.example.hot100;

public class _11 {

    /**
     * 盛最多水的容器
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(nums));
    }

    // 双指针
    public static int maxArea(int[] height) {

        int max = 0;

        int head = 0;
        int tail = height.length - 1;

        while (head != tail) {
            int area;
            if (height[head] >= height[tail]) {
                area = height[tail] * (tail - head);
                tail--;
            } else {
                area = height[head] * (tail - head);
                head++;
            }
            max = Math.max(max, area);
        }

        return max;
    }
}
