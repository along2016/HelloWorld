package com.example.demo;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Season, String> enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.SPRING, "春暖花开");
        enumMap.put(Season.SUMMER, "烈日炎炎");
        enumMap.put(Season.FAIL, "秋风瑟瑟");
        enumMap.put(Season.WINTER, "寒风凛冽");

        System.out.println(enumMap.size());
        System.out.println(enumMap.containsValue("秋风瑟瑟"));
        System.out.println(enumMap.containsKey(Season.FAIL));
        System.out.println(enumMap.get(Season.WINTER));
        System.out.println(enumMap.remove(Season.WINTER));
        System.out.println(enumMap.get(Season.WINTER));

        Map<Season, String> hashMap = new HashMap<>();
        hashMap.put(Season.WINTER, "wangjiliang");
        enumMap.putAll(hashMap);
        System.out.println(enumMap.get(Season.WINTER));
        System.out.println(enumMap.keySet());

        System.out.println(enumMap.values().size());
    }
}

enum Season {
    SPRING,
    SUMMER,
    FAIL,
    WINTER
}