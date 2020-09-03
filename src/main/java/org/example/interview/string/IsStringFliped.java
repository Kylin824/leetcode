package org.example.interview.string;

public class IsStringFliped {
    /*
    面试题 01.09. 字符串轮转
    字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成

    （比如，waterbottle 是 erbottlewat 旋转后的字符串）。

    s1 = s1+s1
    return s1.contains(s2)
     */
    public static boolean isFlipedStringOpt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // 长度不等
        }
        if (s1.equals(s2)) {
            return true; // 无翻转
        }
        s1 = s1 + s1; // waterbottlewaterbottle   则s2 erbottlewat必在s1+s1中
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isFlipedStringOpt("PvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmb",
                "SvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDW"));
    }
}
