package alg.date.March.date0302;

import java.util.LinkedList;

/**
 * 886. 可能的二分法
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，
 * 表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人
 * 分进两组时，返回 true；否则返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 */
public class PossibleBipartition {

    boolean ok = true;
    boolean[] visited;
    boolean[] colored;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        LinkedList<Integer>[] graph = buildGraph(n, dislikes);
        visited = new boolean[n + 1];
        colored = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ok;
    }

    private void traverse(LinkedList<Integer>[] graph, int v) {
        //不满足直接返回
        if (!ok) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            if (visited[w]) {
                if (colored[w] == colored[v]) {
                    ok = false;
                }
            } else {
                //未访问过，则不喜欢的列表 颜色需相反
                colored[w] = !colored[v];
                traverse(graph, w);
            }
        }
    }

    private LinkedList<Integer>[] buildGraph(int n, int[][] dislikes) {
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            //无向图 互相不喜欢
            int w = edge[0];
            int v = edge[1];
            graph[w].add(v);
            graph[v].add(w);
        }
        return graph;
    }
}
