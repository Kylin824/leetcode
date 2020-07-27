package org.example.company.huya;

import org.apache.commons.codec.digest.DigestUtils;

public class MdHex {
    private final static String KEY_PATTERN = "pitaya_%s";

    public static void main(String[] args) {
        String key = String.format(KEY_PATTERN, DigestUtils.md5Hex("00010812-B043-4E17-837D-8D8E568CF0AB"));
        System.out.println(key);
        String str = "abcdefg";
        System.out.println(str.substring(2));
        System.out.println(str.substring(0,2));
        System.out.println(str.substring(0,1));

        System.out.println((0) % 4);
    }
}
