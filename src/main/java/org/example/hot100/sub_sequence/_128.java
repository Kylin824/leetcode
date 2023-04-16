package org.example.hot100.sub_sequence;

import java.util.*;

public class _128 {

    /**
     * 最长连续子序列
     * <p>
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     */

    public static void main(String[] args) {
        _128 o = new _128();

        System.out.println(o.longestConsecutive1(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(o.longestConsecutive2(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(o.longestConsecutive1(new int[]{1, 2, 0, 1, 4, 5}));
        System.out.println(o.longestConsecutive2(new int[]{1, 2, 0, 1, 4, 5}));

    }

    // 排序后遍历  O(nLogn)
    public int longestConsecutive1(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 1;
            while (j + 1 < nums.length) {
                if (nums[j + 1] == nums[j]) {
                    j++;
                } else if (nums[j + 1] == nums[j] + 1) {
                    count++;
                    j++;
                } else {
                    i = j;
                    break;
                }
            }
            max = Math.max(max, count);
            // 遍历的时候  如果下一个满足条件直接跳过
            while (i + 1 < nums.length && (nums[i] == nums[i + 1] || nums[i] + 1 == nums[i + 1])) {
                i++;
            }
        }
        return max;
    }

    // Set O(n)
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            max = Math.max(max, cur - num + 1);
        }
        return max;
    }

    // HashMap 记录右边界 感觉不如set直接 两者速度差不多 这个空间消耗更多
    public int longestConsecutive3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int right = map.get(num);
                while (map.containsKey(right + 1)) {
                    right = map.get(right + 1);
                }
                map.put(num, right);
                max = Math.max(max, right - num + 1);
            }
        }
        return max;
    }

    // dp


}
