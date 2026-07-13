package org.example.hot100_v2.easy.bi_search;

/**
 * @author kylin
 * @date 2026/7/13
 */

public class _69 {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, r = x;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid <= x / mid) {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
//        System.out.println(mySqrt(0)); // 0
//        System.out.println(mySqrt(1)); // 1
//        System.out.println(mySqrt(6)); // 2
//        System.out.println(mySqrt(8)); // 2
//        System.out.println(mySqrt(183692038)); // 13553
        System.out.println(mySqrt(3)); // 13553
//        System.out.println(mySqrt(2147395599)); // 46339
    }
}
