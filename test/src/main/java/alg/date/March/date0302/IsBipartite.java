package alg.date.March.date0302;

import java.util.LinkedList;

/**
 * 785. 判断二分图
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，
 * 其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u
 * 和节点 v 之间的无向边。该无向图同时具有以下属性：
 *
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，
 * 一个来自 B 集合，就将这个图称为 二分图 。
 *
 * 如果图是二分图，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * 输出：false
 * 解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。
 */
public class IsBipartite {


    //双色问题，可以存储 电影与演员关系的映射

    boolean res = true;
    boolean[] visited;
    boolean[] colored;


    //DFS 版本
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        colored = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
//                traverseByDFS(graph, i);
                traverseByBFS(graph, i);
            }
        }
        return res;
    }

    private void traverseByBFS(int[][] graph, int start) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty() && res) {
            int v = queue.poll();
            for (int w : graph[v]) {
                if (visited[w]) {
                    //判断是否一致,一致则不满足
                    if (colored[v] == colored[w]) {
                        res = false;
                    }
                } else {
                    //未访问过，给相邻节点上相反颜色
                    colored[w] = !colored[v];
                    visited[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    private void traverseByDFS(int[][] graph, int v) {
        //已经不满足则返回
        if (!res) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            //已经访问过，判断颜色是否一致
            if (visited[w]) {
                if (colored[w] == colored[v]) {
                    //相同则不满足
                    res = false;
                }
            } else {
                //给另一边上相反的颜色
                colored[w] = !colored[v];
                traverseByDFS(graph, w);
            }
        }
    }
}
