package alg.date.Feb.date0226;

import alg.date.Feb.date0221.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class CountNodes {

    //完全二叉树节点数： 2^n - 1
    //进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = 0, rHeight = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            lHeight++;
            left = left.left;
        }
        while (right != null) {
            rHeight++;
            right = right.right;
        }
        if (lHeight == rHeight) {
            return (int) (Math.pow(2, lHeight) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
}
