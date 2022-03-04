package alg.date.March.date0304;


/**
 * 261. 以图判树 题目：
 *
 * 给你输入编号从0到n - 1的n个结点，和一个无向边列表edges（每条边用节点二元组表示），请你判断输入的这些边组成的结构是否是一棵树。
 *
 * 函数签名如下：
 *
 * boolean validTree(int n, int[][] edges);
 * 比如输入如下：
 *
 * n = 5
 * edges = [[0,1], [0,2], [0,3], [1,4]]
 */
public class ValidTree {


    //有环则不行，即edge的两个节点不连通
    boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (uf.connected(x, y)) {
                return false;
            }
            uf.union(x, y);
        }
        // 要保证最后只形成了一棵树，即只有一个连通分量
        return uf.count() == 1;
    }
}

class UnionFind {

    //连通分量
    private int count;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) {
            return;
        }
        //连通
        parent[pRoot] = qRoot;
        count--;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int x) {
        while (x != parent[x]) {
            //压缩路径
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}