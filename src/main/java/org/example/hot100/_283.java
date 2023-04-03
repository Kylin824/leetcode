package org.example.hot100;

public class _283 {


    public static void main(String[] args) {
        _283 obj = new _283();

        obj.moveZeroes1(new int[]{0,1,0,3,12,0,0,0,0,0});
//        obj.moveZeroes1(new int[]{0,0,0,0,0,0,1,0,3,12});
//        obj.moveZeroes1(new int[]{1,0});
//        obj.moveZeroes(new int[]{1,0,0});

    }

    // 执行用时： 3 ms , 在所有 Java 提交中击败了 12.85% 的用户
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = Math.max(index, i + 1);
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        index = j + 1;
                        break;
                    }
                    j++;
                }
                if (j == nums.length) {
                    break;
                }
            }
        }
    }


    // 双指针
    // 1ms
    public void moveZeroes1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int n = nums[a];
        nums[a] = nums[b];
        nums[b] = n;
    }
}
