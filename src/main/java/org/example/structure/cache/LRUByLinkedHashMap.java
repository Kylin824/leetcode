package org.example.structure.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUByLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUByLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUByLinkedHashMap lru = new LRUByLinkedHashMap(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
    }
}



