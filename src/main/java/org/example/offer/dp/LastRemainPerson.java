package org.example.offer.dp;

public class LastRemainPerson {
    /*
        NO.46
        0-n-1个
        每次喊到m-1的人出列
        剩下最后一个人

     */
    public int LastRemaining_Solution(int n, int m) {
        // 不满足的条件
        if (n <= 0 || m <= 0)
            return -1;
        return n == 1 ? 0 : (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}
