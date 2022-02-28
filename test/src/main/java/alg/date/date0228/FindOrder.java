package alg.date.date0228;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，
 * 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 */
public class FindOrder {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    LinkedList<Integer> postOrder = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        //无法完成
        if (hasCycle) {
            return new int[]{};
        }

        //graph[from] = to 中存储被依赖关系，后序遍历结果需反转为结果
        Collections.reverse(postOrder);

        int[] res = new int[postOrder.size()];
        for (int i = 0; i < postOrder.size(); i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int s) {
        //已经在路径上了
        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        //前序位置
        onPath[s] = true;
        visited[s] = true;
        for (int node : graph[s]) {
            traverse(graph, node);
        }
        //后序位置
        postOrder.add(s);
        onPath[s] = false;
    }

    // graph[from] = to  课程被依赖关系
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] node : prerequisites) {
            int from = node[1];
            int to = node[0];
            graph[from].add(to);
        }
        return graph;
    }


}
