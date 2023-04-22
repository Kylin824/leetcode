package org.example.hot100;

import java.util.ArrayList;
import java.util.List;

public class _139 {

    // todo star

    public static void main(String[] args) {
        _139 o = new _139();
//        List<String> list1 = new ArrayList<String>(){
//            {
//                add("code");
//                add("leet");
//            }
//        };
//        System.out.println(o.wordBreak("leetcode", list1));
//
//        List<String> list2 = new ArrayList<String>(){
//            {
//                add("car");
//                add("ca");
//                add("rs");
//            }
//        };
//        System.out.println(o.wordBreak("cars", list2));
//
//        List<String> list3 = new ArrayList<String>(){
//            {
//                add("a");
//            }
//        };
//        System.out.println(o.wordBreak("a", list3));

//        List<String> list4 = new ArrayList<String>(){
//            {
//                add("cats");
//                add("dog");
//                add("sand");
//                add("and");
//                add("cat");
//                add("an");
//            }
//        };
//        System.out.println(o.wordBreak("catsandogcat", list4));

//        List<String> list5 = new ArrayList<String>(){
//            {
//                add("a");
//                add("aa");
//                add("aaa");
//                add("aaaa");
//                add("aaaaa");
//                add("aaaaaa");
//                add("aaaaaaa");
//                add("aaaaaaaa");
//                add("aaaaaaaaa");
//                add("aaaaaaaaaa");
//            }
//        };
//        System.out.println(o.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list5));


        List<String> list5 = new ArrayList<String>() {
            {
                add("a");
                add("abc");
                add("b");
                add("cd");
            }
        };
        System.out.println(o.wordBreak("abcd", list5));

    }

    // 回溯 + 剪枝
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1]; // 代表s[0到i]这个子串已经dfs过
        for (String substr : wordDict) {
            if (dfs(s, wordDict, substr, substr.length(), visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(String s, List<String> wordDict, String substr, Integer index, boolean[] visited) {
        if (substr.equals(s)) {
            return true;
        }
        for (String word : wordDict) {
            int nextIndex = word.length() + index;
            if (nextIndex > s.length() || visited[nextIndex]) {
                continue;
            }
            if (s.startsWith(substr + word)) {
                if (dfs(s, wordDict, substr + word, nextIndex, visited)) {
                    return true;
                }
                visited[nextIndex] = true;
            }
        }
        return false;
    }

    // dp 背包问题
}
