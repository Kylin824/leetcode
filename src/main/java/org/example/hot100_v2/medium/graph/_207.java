package org.example.hot100_v2.medium.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表
 * @author kylin
 * @date 2026/7/20 23:02
 *
 * 问题理解
 * 我们有 numCourses 门课程，编号从 0 到 numCourses-1。
 * 给定先修课程数组 prerequisites，
 * 其中 prerequisites[i] = [a, b] 表示想学 a，必须先学 b。
 *
 * 即：b -> a 是一条有向边。
 *
 * 目标：判断能否完成所有课程（即图中是否存在环），有环则说明不能修满课程
 *
 * 这是一个有向图环检测问题：
 *
 * 如果图中有环，则环内课程相互依赖，无法完成。
 * 如果无环，则可以完成所有课程（拓扑排序存在）。
 *
 * 解法一： BFS（Kahn 算法，拓扑排序）
 * 构建邻接表，并统计每个节点的入度。
 * 将所有入度为 0 的节点加入队列。
 * 每次取出一个节点，将其所有邻接节点的入度减 1，若入度变为 0 则入队。
 * 统计处理过的节点数，若等于 numCourses 则无环。
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V + E)
 */

public class _207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 以[[1, 0], [2, 0], [3, 1], [3, 2]]为例：

        // 1. 建图 + 统计入度
        // 图（有向边）：
        // 0 → 1
        // 0 → 2
        // 1 → 3
        // 2 → 3
        //
        // 入度表：
        // 课程 0：入度 0
        // 课程 1：入度 1（来自 0）
        // 课程 2：入度 1（来自 0）
        // 课程 3：入度 2（来自 1 和 2）
        //     ┌─────┐
        //     │  0  │  (入度=0)
        //     └──┬──┘
        //        ├──────────┐
        //        ▼          ▼
        //     ┌─────┐   ┌─────┐
        //     │  1  │   │  2  │  (入度=1)
        //     └──┬──┘   └──┬──┘
        //        └─────┬───┘
        //              ▼
        //           ┌─────┐
        //           │  3  │  (入度=2)
        //           └─────┘
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
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (Integer neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // 4. 判断是否所有课程都被处理，是则说明无环
        return count == numCourses;
    }

}
