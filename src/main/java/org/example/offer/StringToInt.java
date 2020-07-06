package org.example.offer;

import javax.lang.model.element.ElementKind;

public class StringToInt {
    /*
        NO.49
        字符串转换成整数
     */
    /*
        难点: 如何处理溢出情况
        INT_MAX =  2147483647 (0x7FFFFFFF)
        INT_MIN = -2147483648 (0x80000000)
     */
    public static int StrToInt(String str) {
        if(str == null || "".equals(str.trim()))return 0;
        char[] arr = str.trim().toCharArray();
        int i = 0;
//        boolean neg = arr[i++] == '-' ? true : false;
        int flag = 1;
        int res = 0;
        if(arr[i] == '-'){
            flag = -1;
        }
        if( arr[i] == '+' || arr[i] == '-'){
            i++;
        }
        while (i < arr.length) {
            // 是数字
            if (arr[i] >= '0' && arr[i] <= '9') {
                int cur = arr[i] - '0'; // 取这个字符
                if (flag == 1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 7)) {
                    return 0; //超过int最大值
                }
                if (flag == -1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 8)) {
                    return 0;
                }
                res = res * 10 + cur;
                i++;
            }
            else {
                // 不是数字
                return 0;
            }
        }
        return res * flag;
    }

    public static void main(String[] args) {
        String str = "+123";
        System.out.println(StrToInt(str));
    }
}
