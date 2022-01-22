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
    }
}
