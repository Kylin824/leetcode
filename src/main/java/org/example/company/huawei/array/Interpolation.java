package org.example.company.huawei.array;

import scala.Int;

import java.util.*;

public class Interpolation {
    /*
        HJ47 线性插值
        1.重复则后来的数据去掉
        2.不连续则插值
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < m; i++) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                if (!map.containsKey(k)) {
                    map.put(k, v);
                }
            }
            ArrayList<Integer> keys = new ArrayList<>(map.keySet());
            int firstKey = keys.get(0);
            int firstValue = map.get(firstKey);
            System.out.println(firstKey + " " + firstValue);
            int currentKey = firstKey;
            int currentValue = firstValue;
            for (int i = 1; i < keys.size(); i++) {
                int newKey = keys.get(i);
                int newValue = map.get(newKey);
                if (newKey > currentKey + 1) {
                    for (int j = 1; j < newKey - currentKey; j++) {
                        System.out.print((currentKey + j) + " ");
                        int tmpValue = currentValue + ((newValue - currentValue) / (newKey - currentKey)) * j;
                        System.out.println(tmpValue);
                    }
                }
                System.out.println(newKey + " " + newValue);
                currentKey = newKey;
                currentValue = newValue;
            }
            System.out.println();
        }
    }
}
