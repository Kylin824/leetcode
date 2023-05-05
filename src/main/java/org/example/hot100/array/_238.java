package org.example.hot100.array;

import java.util.Arrays;

public class _238 {

    public static void main(String[] args) {
        _238 o = new _238();

//        o.productExceptSelf(new int[]{1, 2, 3, 4});
        o.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }

    public int[] productExceptSelf(int[] nums) {


        int[] answer = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = nums.length - 1 - i;
            if (i == 0) {
                left[i] = nums[0];
            } else {
                left[i] = left[i - 1] * nums[i];
            }
            if (j == nums.length - 1) {
                right[j] = nums[nums.length - 1];
            } else {
                right[j] = right[j + 1] * nums[j];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                answer[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                answer[i] = left[i - 1];
            } else {
                answer[i] = left[i - 1] * right[i + 1];
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

}
