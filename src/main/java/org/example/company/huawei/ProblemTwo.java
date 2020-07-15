package org.example.company.huawei;

import java.util.*;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                int len = str.length();
                Map<Character, Integer> map = new HashMap<>();
                // 统计每个字符出现次数
                for (int j = 0; j < str.length(); j++) {
                    if (map.get(str.charAt(j)) != null) {
                        map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
                    }
                    else {
                        map.put(str.charAt(j), 1);
                    }
                }

                Iterator<Integer> iter = map.values().iterator();
                ArrayList<Integer> list = new ArrayList<>();
                while (iter.hasNext()) {
                    list.add(iter.next());
                }
                int sum = 0;
                boolean flag = true;
                for (Integer num : list) {
                    if (num % 2 !=0) {
                        flag = !flag;
                    }
                }

                if (len % 2 == 0 && flag) {
                    System.out.println("Eleanore");
                }
                else if (len % 2 != 0 && flag)
                {
                    System.out.println("Cassidy");
                }
                else {
                    System.out.println("Cassidy");
                }

            }
        }
        sc.close();
    }
}
