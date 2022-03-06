package alg.date.March.date0306;

import ds.array.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，
 * 其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 * 示例 1：
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            // 邻接表存储图结构，同时存储权重信息
            graph[u].add(new int[]{u, v, cost});
        }
        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                // 有节点不可达，返回 -1
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    private int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        //base case
        distTo[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            int curDist = cur.distFromStart;
            if (curDist > distTo[curId]) {
                continue;
            }

            for (int[] neighbor : graph[curId]) {
                int nextId = neighbor[1];
                int distToNextNode = curDist + neighbor[2];
                if (distToNextNode < distTo[nextId]) {
                    //更新
                    distTo[nextId] = distToNextNode;
                    pq.offer(new State(nextId, distToNextNode));
                }
            }
        }

        return distTo;
    }
}


class State {
    int id;

    int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}