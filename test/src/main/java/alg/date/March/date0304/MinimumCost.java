package alg.date.March.date0304;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n + 1);
        int mst = 0;
        // 对所有边按照权重从小到大排序
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            // 若这条边会产生环，则不能加入 mst
            if (uf.connected(u, v)) {
                continue;
            }
            mst += cost;
            uf.union(u, v);
        }
        //0节点未使用，所以存在2个连通分量
        return uf.count() == 2 ? mst : -1;
    }
}
