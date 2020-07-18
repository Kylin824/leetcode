package org.example.offer.array;

import java.util.ArrayList;

public class CombineArrayToMinSum {
    /*
        NO.31
        拼接数组成最小的数字
        例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    /*
        思路: 先把元素按规则排好序，然后连成字符串
            规则如下: strA + strB > strB + strA 则 strB 应该在前面 strA应该在后面
        tips: Compare()默认升序
              Comparator可以函数式编程，写成lambda表达式

     */
    public static String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i : numbers) {
            nums.add(i);
        }
        nums.sort((strA, strB) -> {
            int ab = Integer.parseInt(strA + "" + strB);
            int ba = Integer.parseInt(strB + "" + strA);
            return Integer.compare(ab, ba);
        });
        StringBuilder ret = new StringBuilder();
        for (int i : nums) {
            ret.append(i);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        System.out.println(PrintMinNumber(arr));
    }
}
