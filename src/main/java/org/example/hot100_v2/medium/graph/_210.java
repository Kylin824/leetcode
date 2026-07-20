package org.example.hot100_v2.medium.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kylin
 * @date 2026/7/21 0:34
 */

public class _210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int cource = pre[0]; // 想学的课
            int preCourse = pre[1]; // 先修课
            graph.get(preCourse).add(cource); // 有向图，从pre指向course
            indegree[cource]++; // 统计入度
        }

        // 2. 初始化队列，入度为0的节点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 3. BFS循环处理：弹出节点，遍历邻居，邻居入度-1，为0则入队
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res.add(course);
            for (Integer neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // 4. 判断是否所有课程都被处理，是则说明无环
        return res.size() == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
