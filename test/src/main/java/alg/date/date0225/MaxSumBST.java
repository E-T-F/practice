package alg.date.date0225;

import alg.date.date0221.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 * 二叉搜索树的定义如下：
 *
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 */
public class MaxSumBST {

    int maxSum;
    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return maxSum;
    }


    /**
     * index 0 : 是否为BST 0：不是 1：是
     * index 1 : 树中最大值
     * index 2 : 树中最小值
     * index 3 : 树中节点和
     * @param root
     * @return
     */
    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] leftBST = traverse(root.left);
        int[] rightBST = traverse(root.right);

        //判断当前节点是否为bst,计算sum
        int[] res = new int[4];
        if (leftBST[0] == 1 && rightBST[0] == 1
                && root.val >= leftBST[1]
                && root.val <= rightBST[2]) {
            //是否为BST
            res[0] = 1;
            //树中最大节点值
            res[1] = Math.max(rightBST[1], root.val);
            //树中最小节点值
            res[2] = Math.min(leftBST[2], root.val);
            //树中节点和
            res[3] = leftBST[3] + rightBST[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            //以root为根节点的树不是BST
            res[0] = 0;
        }
        return res;
    }
}
