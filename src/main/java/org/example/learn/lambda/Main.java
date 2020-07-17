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

        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}






