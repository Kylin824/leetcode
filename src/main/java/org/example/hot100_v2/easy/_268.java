package org.example.hot100_v2.easy;

/**
 * 丢失的数字
 * @author kylin
 * @date 2026/7/18
 */

public class _268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            cur += nums[i];
        }
        return sum + nums.length - cur;
    }

    public static void main(String[] args) {
        _268 obj = new _268();
        System.out.println(obj.missingNumber(new int[]{9,0,4,2,3,5,7,8,1}));
    }
}
