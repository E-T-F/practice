package alg.date.March.date0303;

/**
 * 323 无向图中连通分量的数目
 *
 * 题目描述：
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 *
 * 示例 1:
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 *
 */
public class CountComponents {

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.connected(edge[0], edge[1]);
        }
        return uf.count();
    }
}
