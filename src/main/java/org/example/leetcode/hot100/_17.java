package org.example.leetcode.hot100;

import java.util.*;

public class _17 {

    /**
     * 电话号码组合
     * @param args
     */

    public static void main(String[] args) {
        List<String> strings = letterCombinations("234");
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        String[] letterMap = {
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };

        backTrack(res, "", digits, letterMap);

        return res;

    }

    // 回溯
    private static void backTrack(List<String> res, String combination, String digits, String[] letterMap) {
        if (digits.length() == 0) {
            res.add(combination);
            return;
        }
        String letters = letterMap[digits.charAt(0) - 50];
        for (char c : letters.toCharArray()) {
            backTrack(res, combination + c, digits.substring(1), letterMap);
        }

    }

    // 队列
    public static List<String> letterCombinations1(String digits) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        String[] letterMap = {
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };


        char[] chars = digits.toCharArray();

        Queue<String> queue = new ArrayDeque<>();

        queue.add("");

        for (char index : chars) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String tmp = queue.poll();

                String letters = letterMap[index - 50];

                for (int j = 0; j < letters.length(); j++) {
                    char letter = letters.charAt(j);
                    queue.add(tmp + letter);
                }
            }
        }

        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }

        return res;
    }
}
