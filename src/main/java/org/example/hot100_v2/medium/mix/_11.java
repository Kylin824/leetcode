package org.example.hot100_v2.medium.mix;

/**
 * 盛最多水的容器
 * @author kylin
 * @date 2026/7/7
 *
 * 贪心，双指针
 */

public class _11 {

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            // 高度由矮的决定，移动高的只会得到一个更小的乘积，所以要移动矮的一边
            // 这就是这个算法的贪心性质所在：每次排除掉当前较矮的那一侧，因为它不可能作为最优解的边界。
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

}
