package org.example.learn.lambda;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        List<String> list1 =  Arrays.asList( "d", "b", "a" );
//        List<String> list2 = new ArrayList<String>() {
//            {
//                add("dadsasda");
//                add("bsdadsa");
//                add("adsads");
//                add("bdss");
//            }
//        };
//
//        for (String s : list2) {
//            System.out.print(s);
//        }
//
//
//        System.out.println();
//
//        String min = list2.stream().min(Comparator.comparing(String::length)).get();
//
//        System.out.println(min);

//        list1.forEach(e -> System.out.println(e));
//        list1.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
//
//        list1.forEach(System.out::print);

//        BinaryOperator<Integer> add = (x, y) -> {
//            System.out.println("begin");
//            System.out.println(x + y);
//            System.out.println("end");
//            return x + y;
//        };
//        System.out.println(add.apply(3, 4));;

        String baseUrl = "https://test-nativemateriallog.tt.cn/datalog/transform?callbackparam=sv1yT.KZiBbu7lzXdNFcT1kyhhHSuqKmWQY0DRLy3Wsp99VeQWAKKIRLjkulPThLZ0glnVMJVDLPPv7gALneaCqdJbIQnXtYVS-ooRrmhCzSai3yPR0bzYPI77YmuMG70Nc0dnphTyGTxP5ogqDQ7dtZf6SVFmXEZc-zfEn9Fy6nBrh8p8HAKi-ZqdfF6n6aNCLuM0nG8bzT3vJM7IwB8JlnfAA8A9CJ3tDmjL8Yr.RpsO8MYXDt5bfEZbGEr3a9pJZGh.dIHXjt3NlHi8e4qAf6mGSBXRX4vyfgShkXp0I28NfA5Zyvv-WCh5PySUbUb1d1.GFXxzCaOBtWiaE9KZctBo4ftwC5HWmePWA3D4UV-yWxU6GK.j0HnkWQGBSx.VG-dwrFoCB4aCsIv21QBg__&timestamp=1562815154&reqId=null&muid=9782de729d3e031eef1de2a8dd88a63b&os=android&source=__SC__&conv_time=__CONV_TIME__";
        String callbackUrl = URLDecoder.decode(baseUrl, StandardCharsets.UTF_8.toString())
                .replace("__CONV_TIME__", "123456789");
        System.out.println(callbackUrl);
        System.out.println(new StringBuilder(callbackUrl).append("&op2=0&opt_active_time=").append(System.currentTimeMillis() / 1000).toString());

    }
}
