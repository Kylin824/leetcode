package org.example.company.vivo;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = sc.next();
            System.out.println(hasHuiwen(str));
        }
    }

    public static String hasHuiwen(String input) {
        if (input == null || input.length() == 0) {
            return "false";
        }
        char[] chars = input.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            if (chars[begin] == chars[end]) {
                begin++;
                end--;
            }
            else {
                if (isHuiwen(chars, begin + 1, end)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(input, 0, begin).append(input, begin + 1, chars.length);
                    return sb.toString();
                }
                else if (isHuiwen(chars, begin, end - 1)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(input, 0, end).append(input, end + 1, chars.length);
                    return sb.toString();
                }
                else {
                    return "false";
                }
            }
        }
        return begin == end ? input : "false";
    }

    public static boolean isHuiwen(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] == chars[end]) {
                begin++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
}
