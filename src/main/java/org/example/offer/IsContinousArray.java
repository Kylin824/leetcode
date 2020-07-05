package org.example.offer;

import java.util.Arrays;

public class IsContinousArray {
    /*
        NO.45
        如果牌能组成顺子就输出true，否则就输出false。
        例如：{1,3,2,5,4} 输出 true
     */
    /*
        思路:
            1. 排序，然后根据两个条件判断：1.是否重复(1,1...) 2.最小最大值相差大于5
     */
    public static boolean isContinous(int[] numbers) {
        if (numbers.length <= 0)
            return false;
        Arrays.sort(numbers);
        int notZeroIndex = 0; // 找到第一个非0的位置
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                notZeroIndex++;
                continue;
            }
            if (i + 1 < numbers.length && numbers[i] == numbers[i+1])
                return false;
        }
        return numbers[numbers.length - 1] - numbers[notZeroIndex] < 5;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0};
        System.out.println(isContinous(arr));
    }
}
