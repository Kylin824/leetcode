package org.example.hot100_v2.medium.double_pointer;

/**
 * 统计给定字符串的回文子串数目，单个字符也算回文子串
 * @author kylin
 * @date 2026/7/8
 */
public class _647 {

    public static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int l, r;
        for (int i = 0; i < n; i++) {

            // 双指针，奇数子串
            l = i;
            r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }
            // 双指针，偶数子串
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
