package org.example.hot100_v2.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kylin
 * @date 2026/7/6
 */

public class _739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 0;
            if (i > 0 && temperatures[i] == temperatures[i - 1]) {
                res[i] = Math.max(0, res[i - 1] - 1);
                continue;
            }
            for (int j = i; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
    }

}
