package alg.date.March.date0305;

import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    // 核心数据结构，存储「横切边」的优先级队列
    private PriorityQueue<int[]> pq;
    // 类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分
    private boolean[] inMST;
    // 记录 mst 结果
    private int weightMST;
    // 记录邻接表
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>((a, b) -> {
            // 按照边的权重从小到大排序
            return a[2] - b[2];
        });
        int n = graph.length;
        this.inMST = new boolean[n];

        inMST[0] = true;
        //开始切分
        cut(0);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                continue;
            }
            //加入mst
            weightMST += weight;
            inMST[to] = true;
            //将加入的 to 的横切边继续放入优先级队列
            cut(to);
        }
    }

    /**
     * 将 v 的横切边加入优先级队列
     * @param v
     */
    private void cut(int v) {
        for (int[] edge : graph[v]) {
            int to = edge[1];
            if (inMST[to]) {
                // 相邻接点 to 已经在最小生成树中，跳过
                // 否则这条边会产生环
                continue;
            }
            // 加入横切边队列
            pq.offer(edge);
        }
    }

    // 最小生成树的权重和
    public int mst() {
        return weightMST;
    }

    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}

