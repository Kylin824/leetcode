package org.example.company.vivo;

import org.example.leetcode.stack.QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class Main3 {
    public static String compileSeq (String input) {
        // write code here
        if (input == null || input.length() == 0)
            return null;
        String[] strs = input.split(",");
        int[] map = new int[strs.length];
        for (int i = 0; i < map.length; i++) {
            map[i] = Integer.parseInt(strs[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] == -1) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int num = queue.poll();
//            System.out.print(num + ", ");
            sb.append(num).append(",");
            for (int i = 0; i < map.length; i++) {
                if (map[i] == num) {
                    queue.add(i);
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String str = "1,2,-1,1";
        System.out.println(compileSeq(str));
    }
}
