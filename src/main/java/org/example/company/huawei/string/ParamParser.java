package org.example.company.huawei.string;

import akka.stream.javadsl.FileIO;

import java.lang.reflect.Array;
import java.security.interfaces.ECKey;
import java.util.ArrayList;
import java.util.Scanner;

public class ParamParser {
    /*
        HJ74
        xcopy /s c:\ d:\，
        各个参数如下：
        参数1：命令字xcopy
        参数2：字符串/s
        参数3：字符串c:\
        参数4: 字符串d:\
        请编写一个参数解析程序，实现将命令行各个参数解析出来。
        对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int len = 0;
        int quotaNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"') {
                quotaNum++;
                continue;
            }
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else if (quotaNum % 2 == 0) {
                sb.append('\n');
                len++;
            } else {
                sb.append(' ');
            }
        }
        System.out.println(len + 1);
        System.out.println(sb.toString());
    }
}
