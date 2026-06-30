package org.example.hot100_v2;

/**
 * 只出现一次的数字，其余数字都出现2次
 *
 * @author kylin
 * @date 2026/6/29
 */
public class _136 {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 1;
        int n3 = 2;
        System.out.println(n1 ^ n3 ^ n2); // 不同为1， 相同为0
    }

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
