package alg.date.March.date0305;

import java.util.LinkedList;
import java.util.List;

/**
 * 1135 题「最低成本联通所有城市」
 *
 * 想象一下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。
 *
 * 给你一些可连接的选项 connections，其中每个选项 connections[i] = [city1, city2, cost]
 * 表示将城市 city1 和城市 city2 连接所要的成本。（连接是双向的，也就是说城市 city1 和城市 city2
 * 相连也同样意味着城市 city2 和城市 city1 相连）。
 *
 * 返回使得每对城市间都存在将它们连接在一起的连通路径（可能长度为 1 的）最小成本。
 *  该最小成本应该是所用全部连接代价的综合。如果根据已知条件无法完成该项任务，则请你返回 -1。
 *
 * 示例 1：
 *
 *
 * 输入：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
 * 输出：6
 * 解释：
 * 选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
 */
public class MinimumCost {

    public int minimumCost(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        if (!prim.allConnected()) {
            return -1;
        }
        return prim.mst();
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : connections) {
            // 题目给的节点编号是从 1 开始的，
            // 但我们实现的 Prim 算法需要从 0 开始编号
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int weight = edge[2];
            graph[u].add(new int[]{u, v, weight});
            graph[v].add(new int[]{v, u, weight});
        }
        return graph;
    }
}
