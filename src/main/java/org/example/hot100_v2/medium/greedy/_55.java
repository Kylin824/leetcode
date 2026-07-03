package org.example.hot100_v2.medium.greedy;

/**
 * @author kylin
 * @date 2026/7/3
 */
public class _55 {

    // dp解法
    public static boolean canJumpDp(int[] nums) {
        boolean[] ans = new boolean[nums.length];
        ans[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 当前最远能到的点
            int maxJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= maxJump; j++) {
                if (ans[j]) {
                    ans[i] = true;
                    break; // 找到一个就够
                }
            }
        }
        return ans[0];
    }

    // 贪心解法
    public static boolean canJumpGreedy(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump < i) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJumpGreedy(new int[]{2,3,1,1,4})); // true
        System.out.println(canJumpGreedy(new int[]{3,2,1,0,4})); // false
    }
}
