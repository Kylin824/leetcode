package org.example.leetcode.array;

public class CountAndSay {
    /*
    38. 外观数列
    给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
    注意：整数序列中的每一项将表示为一个字符串。
    「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
     */

    public static String qs(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String[] strs = new String[n];
        strs[0] = "1";
        strs[1] = "11";
        for (int i = 2; i < strs.length; i++) {
            StringBuilder cur = new StringBuilder();
            String pre = strs[i - 1];
            int count = 1;
            char now = pre.charAt(0);
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) == now) {
                    count++;
                }
                else if (pre.charAt(j) != now){
                    cur.append(count).append(now);
                    now = pre.charAt(j);
                    count = 1;
                }
                if (j == pre.length() - 1){
                    cur.append(count).append(now);
                }
            }
            strs[i] = cur.toString();
        }
        return strs[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(qs(6));
    }
}
