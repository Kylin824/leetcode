package org.example.offer;

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
//        String res = str.toString().replace(" ", "%20");
//        return res;

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                res.append("%20");
            else
                res.append(str.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello jz offer");
        String res = replaceSpace(stringBuffer);
        System.out.println(res);
    }
}
