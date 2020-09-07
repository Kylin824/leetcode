package org.example.offer.string;

public class ReplaceSpace {
    /*
        NO.02
        将一个字符串中的每个空格替换成 “%20”
     */
    /*
        思路:
            1. replace(" ", "%20")
            2. 依次判断每个字符 chatAt()，如果是空格则替换为 "%20"
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                res.append("%20");
            else
                res.append(str.charAt(i));
        }
        return res.toString();
    }

    public String replaceSpace1(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello jz offer");
        String res = replaceSpace(stringBuffer);
        System.out.println(res);
    }
}
