package org.example.company.huawei.string;
import java.util.Scanner;
public class CountUpperChar {
    /*
       HJ84 统计大写字符
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i)))
                    num++;
            }
            System.out.println(num);


        }
    }
}
