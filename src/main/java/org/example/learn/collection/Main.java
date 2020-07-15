package org.example.learn.collection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        map.put("hollis", "hollischuang");

        Class<?> mapType = map.getClass(); // get Class
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.forEach(System.out::println);

        System.out.println(Season.SPRING);
    }

    private static enum Season {
        SPRING, SUMMER, AUTUMN, WINTER;
    }
}
