package org.example.hot100.bit;

public class _136 {

    /**
     * 非空整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     *  1⊕2⊕3⊕2⊕1
     * =1⊕1⊕2⊕2⊕3
     * =0⊕0⊕3
     * =0⊕3
     * =3
     */

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
