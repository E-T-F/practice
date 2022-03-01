package alg.date.date0224;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {

    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return numBST(1, n);
    }

    private int numBST(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        //以 i 为根节点
        int num = 0;
        for (int i = start; i <= end; i++) {
            int leftNum = numBST(start, i - 1);
            int rightNum = numBST(i + 1, end);
            num += leftNum * rightNum;
        }
        memo[start][end] = num;
        return num;
    }
}
