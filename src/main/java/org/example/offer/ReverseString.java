package org.example.offer;

public class ReverseString {
    /*
        NO.44
        翻转字符串
     */
    /*

     */
    public static String reverseSentence(String str) {

        if (str == null || str.trim().equals("")) {
            return str;
        }
        else {
            String[] words = str.split(" ");
            StringBuilder ret = new StringBuilder();
            for (int i = words.length - 1; i > 0; i--) {
                ret.append(words[i]).append(" ");
            }
            ret.append(words[0]);
            return ret.toString();
        }
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(reverseSentence(str));
    }
}
