package alg.date.March.date0301;

import java.util.LinkedList;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class CanFinish {


    //BFS版本，while {入度为0的弹出，减少对应关联节点的入度}
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        LinkedList<Integer>[] graph = buildGraph(numCourses, prerequisites);

        LinkedList<Integer> queue = new LinkedList<>();

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 需要依赖课程的 入度++
            indegree[to]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                //入度等于0 即没有依赖课程，加入队列
                queue.offer(i);
            }
        }
        //记录遍历的节点个数
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            //减少依赖它节点的入度
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    //如果该课程也没有依赖，则入队列
                    queue.offer(next);
                }
            }
        }

        return numCourses == count;
    }

    //邻接表，graph[from]， 学完 from 课程，就可以学习 to 课程
    private LinkedList<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        LinkedList<Integer>[] graph = new LinkedList[numCourses];

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
