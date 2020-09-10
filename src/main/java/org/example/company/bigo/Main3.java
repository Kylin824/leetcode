package org.example.company.bigo;

import java.util.*;

public class Main3 {
    public static List<List<String>> mirror (List<List<String>> data) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            StringBuilder row = new StringBuilder(data.get(i).get(0));
            StringBuilder rev = new StringBuilder(row);
            rev.append(row.reverse());
            List<String> newRow = new ArrayList<String>(){{add(rev.toString());}};
            res.add(newRow);
        }
        List<List<String>> resMirror = new ArrayList<>(res);
        Collections.reverse(resMirror);
        res.addAll(resMirror);
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> row1 = new ArrayList<String>(){{add("ABC");}};
        input.add(row1);
        List<String> row2 = new ArrayList<String>(){{add("DEF");}};
        input.add(row2);
        List<List<String>> res = mirror(input);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }
}
