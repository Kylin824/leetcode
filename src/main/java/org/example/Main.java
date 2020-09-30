package org.example;

import org.example.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        int[] A = {10,1,2,7,6,1,5};
        int target = 8;

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            dfs(A, i, target, arr);
            res.add(arr);
        }
        for (int j = 0; j < res.size(); j++) {
            ArrayList<Integer> arr = res.get(j);
            for (int k = 0; k < arr.size(); k++) {
                System.out.println(arr.get(k) + " ");
            }
        }
    }
    public static void dfs(int[] nums, int index, int target, ArrayList<Integer> arr) {
        if (target == 0) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] < target) {
                arr.add(nums[i]);
                dfs(nums, i + 1, target - nums[i], arr);
            }
            else if (nums[i] == target) {
                arr.add(nums[i]);
                return;
            }
            else {
                if (arr.size() > 0) {
                    arr.remove(arr.size() - 1);
                    return;
                }
            }
        }
    }
}
