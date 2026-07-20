package org.example.hot100_v2.medium.alg;


import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组
 *
 * 核心思路：Fisher-Yates 洗牌算法
 * 这个算法的核心是从后往前遍历数组，
 * 每一步从当前位置到数组末尾之间，随机选一个位置，然后交换这两个位置的元素。
 *
 * 这个过程可以这样理解：
 * 我们每次为当前位置 i 从所有剩余未处理的元素中，等概率地选一个放过来。
 * 这样，每个元素出现在每个位置的概率都是均等的，
 * 保证了 n! 种排列结果等可能出现
 *
 * @author kylin
 * @date 2026/7/20 20:32
 */

public class _384 {

    private int[] origin;
    private int[] current;
    private Random random;

    public _384(int[] nums) {
        origin = nums.clone();
        current = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        this.current = origin.clone();
        return this.current;
    }

    public int[] shuffle() {
        for (int i = this.current.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = this.current[i];
            this.current[i] = this.current[j];
            this.current[j] = tmp;
        }
        return this.current;
    }
}
