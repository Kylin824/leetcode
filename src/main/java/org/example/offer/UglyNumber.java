package org.example.offer;

public class UglyNumber {
    /*
        NO.32
        只包含质因子2、3和5的数称作丑数（Ugly Number）。
        例如6、8都是丑数，但14不是，因为它包含质因子7。
        习惯上我们把1当做是第一个丑数。
        求按从小到大的顺序的第N个丑数。
     */
    /*
        思路: 穷举
            给定一个数:
                先 2x2x...x2 直到超过..
                然后 2x2x..x3 直到超过..
                最后 5x5x..x5直到超过..

            eg: 25
                2x2x2x2x2超过
                2x2x2x3小于
                2x2x3x3超过
                2x2x3小于
                2x3x3小于
                3x3x3超过
                3x5小于
                5x5等于
                5小于


     */

    public static int GetUglyNumber_Solution(int index) {
        int i = 1;
        int count = 1;
        while (count != index) {
            if (isUglyNum(i)) {
                System.out.println(i);
                count++;
                if (index == count)
                    return i;
            }
            i++;
        }
        return 1;
    }

    public static boolean isUglyNum(int input) {
        int c2 = (int) Math.sqrt(input);
        int c3 = 0;
        int c5 = 0;
        while (c2 > 0 || c3 > 0 || c5 > 0) {
            int sum = (int) (Math.pow(2, c2) * Math.pow(3, c3) * Math.pow(5, c5));
            
            if (sum == input) {
                return true;
            }
            else if (sum > input) {
                if (c2 > 0)
                    c2--;
                else if (c2 == 0 && c3 > 0)
                    c3--;
                else if (c2 == 0 && c3 == 0)
                    c5--;
            }
            else {
                // sum < input
                if (c2 > 0) {
                    c2--;
                    c3++;
                }
                else if (c2 == 0 && c3 > 0){
                    c3--;
                    c5++;
                }
                else if (c2 == 0 && c3 == 0) {
                    c5--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(100));
    }
}
