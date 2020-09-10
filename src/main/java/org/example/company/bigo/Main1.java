package org.example.company.bigo;

import scala.Int;

import java.text.DecimalFormat;

public class Main1 {


    public static String calLoad(String param) {
        String[] strs = param.split(" ");
        int diskSize = Integer.parseInt(strs[0]);
        int memSize = Integer.parseInt(strs[1]);
        String[] servs = strs[2].split("#");
        int[][] m = new int[servs.length][3];
        for (int i = 0; i < servs.length; i++) {
            String[] serv = servs[i].split(",");
            for (int j = 0; j < 3; j++) {
                int n = Integer.parseInt(serv[j]);
                m[i][j] = n;
            }
        }
        int max = 0;
        int memUsed = 0;
        int diskUsed = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m.length; j++) {
                for (int k = 0; k < 3; k++) {
                    int disk = m[i][0] + m[j][0];
                    int mem = m[i][1] + m[j][1];
                    if (disk <= 15 && mem <= 10) {
                        if (max < m[i][2] + m[j][2]) {
                            max = m[i][2] + m[j][2];
                            memUsed = mem;
                            diskUsed = disk;
                        }

                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0");//设置保留位数
        String memper = df.format((float)memUsed / memSize * 100);
        String diskper = df.format((float)diskUsed / diskSize * 100);
        res.append(max).append(",").append(diskper).append("%,").append(memper).append("%");
        return res.toString();
    }

    public static void main(String[] args) {
        String input = "15 10 5,1,1000#2,3,3000#5,2,15000#10,4,16000";
        System.out.println(calLoad(input));
    }
}
