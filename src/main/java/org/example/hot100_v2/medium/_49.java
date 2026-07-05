package org.example.hot100_v2.medium;

import java.util.*;

/**
 * 字母异位词分组
 * @author kylin
 * @date 2026/7/6
 */

public class _49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(new ArrayList<>(entry.getValue()));
        }
        return res;
    }

}
