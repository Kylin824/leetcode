package org.example.interview.binsearch;

public class FindString {
    /*
    面试题 10.05. 稀疏数组搜索
    稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串
    编写一种方法，找出给定字符串的位置。
    */

    public int findStringForce(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public static int findStringBinSearch(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int tmp = mid;
            while (mid < r && words[mid].equals(""))
                mid++; // 右边第一个非空字串
            if (words[mid].equals("")) {
                r = tmp - 1;
                continue;
            }
            if (words[mid].equals(s)) {
                return mid;
            }
            else if (words[mid].compareTo(s) < 0) { // words[mid] < s
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int findStringBinSearchOpt(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (l <= r) {
            while (words[l].equals("")) l++;
            while (words[r].equals("")) r--;
            int mid = (r - l) / 2 + l;
            while (mid < r && words[mid].equals(""))
                mid++; // 右边第一个非空字串
            if (words[mid].equals(s)) { // 找到
                return mid;
            }
            else if (words[mid].compareTo(s) < 0) { // words[mid] < s
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] words = {"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"};
        String s = "mCrS";
        System.out.println(findStringBinSearch(words, s));
        System.out.println("a".compareTo("b"));
    }
}
