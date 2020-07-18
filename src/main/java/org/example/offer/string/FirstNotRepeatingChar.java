package org.example.offer.string;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    /*
        NO.34
        在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
        如果没有则返回 -1（需要区分大小写）（从0开始计数）
     */
    /*
        思路:
            1. 哈希法，利用map或者数组计算每个字符出现的次数

            2. BitSet
     */
    public static int firstNotRepeatingChar1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null)
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static int firstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(128);
        BitSet bs2 = new BitSet(128);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                // 第一次出现
                bs1.set(c);
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);
        }
        for (int i = 0; i < str.length(); i++) {
            if (bs1.get(str.charAt(i)) && !bs2.get(str.charAt(i)))
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = "hjaksdaiojxznmKah";
        System.out.println(firstNotRepeatingChar2(str));
    }
}
