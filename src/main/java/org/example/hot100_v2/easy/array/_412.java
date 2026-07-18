package org.example.hot100_v2.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @date 2026/7/18
 */

public class _412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }
}
