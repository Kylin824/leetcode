package org.example.hot100;

/**
 * @author kylin
 * @date 2023/4/7
 */
public class _9 {

    public static void main(String[] args) {
        _9 c = new _9();
        c.isPalindrome(121);
    }

    /**
     * 判断回文数 121 √ 123 ×
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int res = 0;
        while (tmp != 0) {
            int yu = tmp % 10;
            res = res * 10 + yu;
            tmp = tmp / 10;
        }
        return res == x;
    }

}
