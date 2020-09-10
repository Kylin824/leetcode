package org.example.company.dianxin;

public class Main2 {

    public static void main(String[] args) {
        for (int a = 0; a <= 8; a++) {
            for (int b = 0; b <= 9; b++) {
                if (a * 1000 + b * 1000 < 7000)
                    break;
                for (int c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        int res = (a * 1000 + b * 100 + c * 10 + d) + (b * 1000 + c * 100 + d * 10 + a);
                        if (res == 8888) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                        }
                    }
                }
            }
        }
    }

}
