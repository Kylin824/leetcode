package org.example.interview.string;

public class EditOnce {
    /*
    面试题 01.05. 一次编辑
    字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
    给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

    思路：如果长度相同，则只可能是替换
         如果长度不同，则只可能是插入删除

         定位到不同字符处。有以下两种情况
            （1）长度相同：leetcode 与 leetkode。
            那么我们需要找到 'c' 和 'k'，然后比较 'ode' 和 'ode' 是否相同。
            （2）长度不同：leetcode 与 leetode。
            我们发现 'c' 和 'o' 不相同，然后比较 'ode' 和 'ode' 是否相同。
            （3）长度不同：leetode 与 leetkode。
            我们发现 'o' 和 'k' 不相同，然后比较 'ode' 和 'ode' 是否相同。
     */
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) // 长度超过1
            return false;
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (len1 < len2)
                    return first.substring(i).equals(second.substring(i + 1));
                else if (len1 == len2)
                    return first.substring(i + 1).equals(second.substring(i + 1));
                else
                    return first.substring(i + 1).equals(second.substring(i));
            }
        }
        return true;
    }
}
