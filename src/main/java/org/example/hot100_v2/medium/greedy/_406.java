package org.example.hot100_v2.medium.greedy;

import java.util.Arrays;

/**
 * 根据身高重建队列
 * @author kylin
 * @date 2026/7/3
 */
public class _406 {
    public static int[][] reconstructQueue(int[][] people) {

        // [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]

        // [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]

        //


        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                // 身高相同，排位小的排前面
                return a[1] - b[1];
            }
            // 身高高的排前面
            return b[0] - a[0];
        });
        int[][] res = new int[people.length][people[0].length];
        for (int i = 0; i < people.length; i++) {
            int h = people[i][0]; // 第i个 身高h 对应前面要有pos个位置
            int pos = people[i][1];

            // 往右挪出位置，给出位置插入
            for (int j = i; j > pos; j--) {
                res[j] = res[j - 1];
            }
            res[pos] = people[i];
        }
        return res;
    }

    public static void main(String[] args) {
        for (int[] ints : reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
