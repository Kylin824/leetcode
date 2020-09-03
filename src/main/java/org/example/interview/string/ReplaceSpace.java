package org.example.interview.string;

import java.util.Arrays;

public class ReplaceSpace {
    /*
    URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
    （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
    示例1:
     输入："Mr John Smith            ", 13
     输出："Mr%20John%20Smith"
     */
    public static String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int j = length - 1;
        int count = 0;
        while (j >= 0) {
            if (chars[j--] == ' ')
                count++;
        }
        j = length - 1;
        int i = length + 2 * (count) - 1;
        while (j >= 0) {
            if (chars[j] != ' ') {
                chars[i] = chars[j];
            }
            else {
                chars[i--] = '0';
                chars[i--] = '2';
                chars[i] = '%';
            }
            j--;
            i--;
        }
        return String.valueOf(chars).substring(0, length + 2 * count);
    }

    public static String replaceSpacesFunc(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

    public static String replaceSpacesOpt(String S, int length) {
        char[] chars = S.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ')
                spaceCount++;
        }
        int index = length + 2 * (spaceCount);
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index = index - 3;
            }
            else {
                chars[index - 1] = chars[i];
                index--;
            }
        }
        return String.valueOf(chars).substring(0, length + 2 * spaceCount);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
    }
}
