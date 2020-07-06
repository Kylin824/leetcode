package org.example.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstAppearCharInString {
    /*
        NO.54
        实现一个函数用来找出字符流中第一个只出现一次的字符。
        例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
        当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
        如果当前字符流没有存在出现一次的字符，返回#字符。
        输入"google" 输出"ggg#ll"
     */
    /*
        思路:
            1. 哈希+队列
            哈希记录字符出现次数, 第一次出现时添加到队列中, 重复出现时出队
     */
    static Map<Character, Integer> map = new HashMap<>();
    static Queue<Character> queue = new LinkedList<>();

    //Insert one char from string stream
    public static void Insert(char ch)
    {
        if (map.get(ch) == null) {
            map.put(ch, 1);
            queue.offer(ch);
        }
        else {
            map.put(ch, map.get(ch) + 1);
            if (queue.size() > 0 && queue.peek() == ch) {
                queue.poll();
            }
        }
    }
    //return the first appearance once char in current string stream
    public static char FirstAppearingOnce()
    {
        while (queue.size() > 0) {
            char ret = queue.peek();
            if (map.get(ret) > 1) { // 如果队头元素出现次数不止1次则直接出队丢弃
                queue.poll();
            }
            else
                return ret;
        }
        return '#';
    }

    public static void main(String[] args) {
        Insert('g');
        System.out.print(FirstAppearingOnce());
        Insert('o');
        System.out.print(FirstAppearingOnce());
        Insert('o');
        System.out.print(FirstAppearingOnce());
        Insert('g');
        System.out.print(FirstAppearingOnce());
        Insert('l');
        System.out.print(FirstAppearingOnce());
        Insert('e');
        System.out.print(FirstAppearingOnce());
    }
}
