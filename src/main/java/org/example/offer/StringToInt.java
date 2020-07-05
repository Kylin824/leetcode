package org.example.offer;

import javax.lang.model.element.ElementKind;

public class StringToInt {
    /*
        NO.49
        字符串转换成整数
     */
    /*
        难点: 如何处理溢出情况

     */
    public int StrToInt(String str) {
        if(str == null || "".equals(str.trim()))return 0;
        char[] arr = str.trim().toCharArray();
        int i = 0;
        boolean neg = arr[i++] == '-' ? true : false;
        int res = 0;
        while (i < arr.length) {
            // 是数字
            if (arr[i] >= '0' && arr[i] <= '9') {
                int cur = arr[i] - '0';
                if (neg == 1 && )
            }
        }

    }
}
