package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {

        int[] A = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(A);


        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(A, 0, target, path);

        for (int j = 0; j < res.size(); j++) {
            ArrayList<Integer> arr = res.get(j);
            for (int k = 0; k < arr.size(); k++) {
                System.out.print(arr.get(k) + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(int[] nums, int index, int target, ArrayList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target)
                break;
            if (i > index && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], path);
            path.remove(path.size() - 1);
        }
    }
}
