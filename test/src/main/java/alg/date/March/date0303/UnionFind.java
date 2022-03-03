package alg.date.March.date0303;

public class UnionFind {

    //连通数量
    private int count;
    //存储每个节点的父节点
    private int[] parent;
    
    public UnionFind(int n) {
        //初始化
        count = n;
        parent = new int[n];
        //根节点的parent为自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //连通节点 p 和 节点q
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        //已连通
        if (pRoot == qRoot) {
            return;
        }
        //将两个连通分量合并
        parent[pRoot] = qRoot;
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    // 返回节点 x 的连通分量根节点
    private int findRoot(int x) {
        while (x != parent[x]) {
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //返回连通分量
    public int count() {
        return this.count;
    }
}
