package org.example.company.alibaba;

public class NameConvertSolution {

    public static void main(String[] args) {
        String input = "my_book_name";
        System.out.println(toLowerCamelCase(input));
    }

    // 不使用系统库
    public static String toLowerCamelCase(String input) {
        char[] chars = input.toCharArray();
        char[] ret = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                if (i + 1 < chars.length)
                    ret[i + 1] = (char) (chars[i + 1] - 32);
                i++;
            }
            else {
                ret[i] = chars[i];
            }
        }
        return new String(ret);
    }
}
