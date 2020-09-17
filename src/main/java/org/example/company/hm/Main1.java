package org.example.company.hm;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] suc = {"0","1","2","3","4","3",
                "2","1","5","6","5","7",
                "8","9","8","7","5","1","0"};
        int flag = 0;
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(",");
            String last = "";
            int cur = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals(last)) {
                    continue;
                }
                else if (cur < suc.length && strs[i].equals(suc[cur])) {
                    last = strs[i];
                    cur++;
                }
                else if (cur == suc.length){
                    flag = 4;
                    break;
                }
                else if (strs[i].equals("-1")){
                    flag = 1;
                    break;
                }
                else if (strs[i].charAt(0) >= 'A' && strs[i].charAt(0) <= 'F'){
                    flag = 2;
                    break;
                }
                else {
                    flag = 3;
                    break;
                }
            }
            if (flag == 0 || flag == 4)
                System.out.println("Success");
            else if (flag == 1)
                System.out.println("Out of path");
            else if (flag == 2)
                System.out.println("Collision");
            else if (flag == 3)
                System.out.println("Bad path");
        }
    }
}
