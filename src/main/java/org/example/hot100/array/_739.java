package org.example.hot100.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kylin
 * @date 2023/5/22
 */
public class _739 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
//        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
//        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71})));
    }

    // 二重循环 超时
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            res[i] = 0;
            if (i == temperatures.length - 1) {
                continue;
            }
            if (temperatures[i] == temperatures[i + 1]) {
                res[i] = res[i + 1] == 0 ? 0 : res[i + 1] + 1;
            }

            int count = 1;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = count;
                    break;
                } else {
                    count++;
                }
            }
        }
        return res;
    }

    //
    public static int[] dailyTemperatures1(int[] temperatures) {
        if (temperatures.length == 0) {
            return null;
        }
        int[] res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures[temperatures.length - 1]);
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] == temperatures[i + 1]) {
                res[i] = res[i + 1] == 0 ? 0 : res[i + 1] + 1;
                stack.push(stack.peek());
                continue;
            }
            int cur = temperatures[i];
            int count = 1;
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
                count++;
            }
            // 说明后面没有比cur更大的值
            if (stack.isEmpty()) {
                res[i] = 0;
                stack.push(cur);
            }
            // 有比cur更大的值
            else {
                res[i] = count;
                while (count-- > 0) {
                    stack.push(cur);
                }
            }
        }
        return res;
    }

}
