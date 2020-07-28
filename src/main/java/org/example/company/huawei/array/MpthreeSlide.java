package org.example.company.huawei.array;

import java.util.Scanner;

public class MpthreeSlide {
    /*
    HJ64 MP3光标移动与翻页
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String command = sc.next();
            if (n > 4) {
                int index = 1;
                int upbound = 1;
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == 'U') {
                        if (index > 1) {
                            index--;
                            if (index < upbound) {
                                upbound = index;
                            }
                        } else {
                            // 第一行，跳到最后一行
                            index = n;
                            upbound = index - 3;
                        }
                    } else {
                        if (index < n) {
                            // 未到底
                            index++;
                            if (index - upbound >= 4) {
                                upbound++;
                            }
                        } else {
                            // 已到底，下一个为第一行
                            index = 1;
                            upbound = 1;
                        }
                    }
                }
                for (int i = upbound; i < upbound + 3; i++) {
                    System.out.print(i + " ");
                }
                System.out.println(upbound + 3);
                System.out.println(index);
            }
            else {
                for (int i = 1; i < n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println(n);
                int index = 1;
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == 'U') {
                        index--;
                        if (index <= 0)
                            index = n;
                    }
                    else {
                        index++;
                        index = index % n;
                    }
                }
                System.out.println(index);
            }
        }

    }
}
