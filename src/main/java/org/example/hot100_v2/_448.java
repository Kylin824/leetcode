package org.example.hot100_v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @date 2026/6/30
 */
public class _448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }
        List<Integer> res = new ArrayList<>();
        int n = 1;
        for (int num : nums) {
            if (num != n) {
                res.add(n);
            }
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{2,3,2,4}));
    }

}
