package org.example.hot100_v2.easy.double_pointer;

/**
 * 验证回文串
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * @author kylin
 * @date 2026/7/14
 */

public class _125 {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!isNumber(ci) && !isBigLetter(ci) && !isSmallLetter(ci)) {
                i++;
                continue;
            }
            if (!isNumber(cj) && !isBigLetter(cj) && !isSmallLetter(cj)) {
                j--;
                continue;
            }
            // 数字
            if (isNumber(ci)) {
                if (isNumber(cj)) {
                    if (ci != cj) {
                        return false;
                    }
                    i++;
                    j--;
                    continue;
                } else {
                    return false;
                }
            }
            // 大写字母
            if (isBigLetter(ci)) {
                if (isBigLetter(cj)) {
                    if (ci != cj) {
                        return false;
                    }
                    i++;
                    j--;
                    continue;
                } else if (isNumber(cj)) {
                    return false;
                } else if (isSmallLetter(cj)) {
                    if (ci + ('a' - 'A') != cj) {
                        return false;
                    }
                    i++;
                    j--;
                    continue;
                }
            }
            // 小写字母
            if (isSmallLetter(ci)) {
                if (isSmallLetter(cj)) {
                    if (ci != cj) {
                        return false;
                    }
                    i++;
                    j--;
                    continue;
                } else if (isNumber(cj)) {
                    return false;
                } else if (isBigLetter(cj)) {
                    if (ci - ('a' - 'A') != cj) {
                        return false;
                    }
                    i++;
                    j--;
                    continue;
                }
            }
        }
        return true;
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    public boolean isBigLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }
    public boolean isSmallLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        _125 obj = new _125();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
