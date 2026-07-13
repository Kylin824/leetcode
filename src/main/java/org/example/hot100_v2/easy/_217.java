package org.example.hot100_v2.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kylin
 * @date 2026/7/14
 */

public class _217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

}
