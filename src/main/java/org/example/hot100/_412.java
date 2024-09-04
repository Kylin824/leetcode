package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @date 2024/9/4
 */
public class _412 {

    public static void main(String[] args) {
        System.out.println(_412.fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                res.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
