package alg.date.date0227;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 * 示例 1：
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 */
public class AllPathsSourceTarget {

    //结果集
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int start, LinkedList<Integer> path) {
        //加入路径
        path.add(start);

        int n = graph.length;
        //到达目标节点，添加结果集
        if (start == n - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //递归遍历相邻节点
        for (int v : graph[start]) {
            traverse(graph, v, path);
        }
        //路径中移除节点
        path.removeLast();
    }

}
