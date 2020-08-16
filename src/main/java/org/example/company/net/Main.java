package org.example.company.net;

import org.apache.arrow.flatbuf.Bool;
import org.apache.hadoop.util.hash.Hash;
import org.apache.spark.sql.sources.In;
import scala.Int;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> mrr = new ArrayList<>();
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int inn = in.nextInt();
                mrr.add(inn);
                map.put(inn, true);
            }
            ArrayList<Integer> ret = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
//                if (mrr.contains(i)) {
                if (map.get(i) != null && map.get(i)) {
                    if (mrr.get(0) == i) {
                        // 首位
                        ret.add(i);
                        mrr.remove(0);
                        map.put(i, false);
                        Iterator<Integer> it = mrr.iterator();
                        while (it.hasNext()) {
                            int tmp = it.next();
                            if (tmp < i) {
                                ret.add(tmp);
                                it.remove();
                            }
                            else {
                                break;
                            }
                        }
                    }
                }
                else {
                    ret.add(i);
                }
            }
            for (int i = 0; i < ret.size() - 1; i++) {
                System.out.print(ret.get(i) + " ");
            }
            if (mrr.size() > 0) {
                System.out.print(ret.get(ret.size() - 1) + " ");
                for (int i = 0; i < mrr.size() - 1; i++) {
                    System.out.print(mrr.get(i) + " ");
                }
                System.out.println(mrr.get(mrr.size() - 1));
            }
            else {
                System.out.println(ret.get(ret.size() - 1));
            }
        }
    }
}