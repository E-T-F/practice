package alg.date.March.date0304;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 * 示例 1：
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 */
public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[] {
                        i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        //按权重从小到大排列
        int mst = 0;
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            //存在环不加入mst
            if (unionFind.connected(u, v)) {
                continue;
            }
            mst += weight;
            unionFind.union(u, v);
        }
        return mst;
    }
}
