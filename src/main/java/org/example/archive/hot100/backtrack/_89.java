package org.example.archive.hot100.backtrack;

//n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
//
//
// 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1）
// 第一个整数是 0
// 一个整数在序列中出现 不超过一次
// 每对 相邻 整数的二进制表示 恰好一位不同 ，且
// 第一个 和 最后一个 整数的二进制表示 恰好一位不同
//
//
// 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：[0,1,3,2]
//解释：
//[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
//- 00 和 01 有一位不同
//- 01 和 11 有一位不同
//- 11 和 10 有一位不同
//- 10 和 00 有一位不同
//[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
//- 00 和 10 有一位不同
//- 10 和 11 有一位不同
//- 11 和 01 有一位不同
//- 01 和 00 有一位不同
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 16
//
//
// Related Topics 位运算 数学 回溯 👍 669 👎 0

import java.util.ArrayList;
import java.util.List;

public class _89 {

    // 格雷码公式：n xor (n >> 1)
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }

    /* 找规律
     * n = 1,   n = 2,   n = 3
     *  0        0 0      0 00
     *  1        0 1      0 01  即 0+(n=2)
     *           1 1      0 11
     *           1 0      0 10
     *                    1 10
     *                    1 11  即 1+(n=2倒过来)
     *                    1 01
     *                    1 00
     */
    public List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j)); // 二进制首位加一个1
            }
            head <<= 1;
        }
        return res;
    }


    /* 回溯
       规律是：偶数个1则先补0，奇数个1则先补1
       由此顺序是：
       n = 0                          0
       n = 1               00                   01
       n = 2          000      001        011       010
       n = 3      0000 0001 0011 0010  0110 0111 0101 0100
    */

    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(n, new StringBuilder(), res);
        return res;
    }

    public void dfs(int n, StringBuilder sb, List<Integer> res) {
        int cur = 0;
        if (sb.length() > 0) {
            cur = Integer.valueOf(sb.toString(), 2); // 二进制字符串转十进制整数
        }
        if (sb.length() == n) {
            res.add(cur);
            return;
        }
        int count = Integer.bitCount(cur); // 偶数个1则先补0，奇数个1则先补1
        sb.append(count % 2 == 0 ? "0" : "1");
        dfs(n, sb, res);
        sb.deleteCharAt(sb.length() - 1); // 回溯状态
        sb.append(count % 2 == 0 ? "1" : "0");
        dfs(n, sb, res);
        sb.deleteCharAt(sb.length() - 1); // 回溯状态
    }


    public static void main(String[] args) {
        _89 a = new _89();
        System.out.println(a.grayCode(3));
        System.out.println(a.grayCode1(3));
        System.out.println(a.grayCode2(3));
        System.out.println(a.grayCode(4));
        System.out.println(a.grayCode1(4));
        System.out.println(a.grayCode2(4));

    }
}
