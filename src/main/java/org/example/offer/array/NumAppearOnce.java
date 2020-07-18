package org.example.offer.array;

public class NumAppearOnce {
    /*
        NO.40
        一个整型数组里除了两个数字之外，其他的数字都出现了两次。
        找出这两个只出现一次的数字。
     */
    /*
        思路:
            1. 如果只有一个数字出现一次，则从第一个到最后一个数两两异或得到最后的数 n 就是唯一出现一次的数

            2. 如果两个数字出现一次，则同样两两异或，最后的结果 n 就是这两个不同的数异或的结果
            考虑如何从 n 中获得这两个不同的数 a, b:
                n的二进制中为1的位，代表 a,b中不同的位，取任意一个n中的1所在的位 index（这里取第一个），
                将原数组按此位是否为1分成两组，这样a,b必定在不同分组中，并且其他出现两次的数必定在同一分组中

                问题即转化为两个数组，每个数组中只有一个数字出现一次！
            xor:不同为1 相同为0
     */
    public void FindNumsAppearOnce(int[] array, int num1[] ,int num2[]) {
        int n = array[0];
        for (int i = 1; i < array.length; i++) {
            n = n ^ array[i]; // 异或
        }
        // 获取n二进制中为1的位置
        int index = 1;
        while ((index & n) == 0)
            index <<= 1;

        int ret1 = 0;
        int ret2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & index) == 0) {
                ret1 = ret1 ^ array[i];
            } else {
                ret2 = ret2 ^ array[i];
            }
        }
        num1[0] = ret1;
        num2[0] = ret2;
    }
}
