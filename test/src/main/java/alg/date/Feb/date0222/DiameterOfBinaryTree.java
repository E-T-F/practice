package alg.date.Feb.date0222;

import alg.date.Feb.date0221.TreeNode;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class DiameterOfBinaryTree {


    public int res;
    /**
     * 一个节点最大直径长度等于  左子树的最大深度 + 右子树的最大深度
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }


    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        //最大深度的后序遍历，可以获得该节点的最大直径
        res = Math.max(leftMax + rightMax, res);
        return Math.max(leftMax, rightMax) + 1;
    }


    /**
     * 简单粗暴
     * @param root
     * @return
     */
    int maxRes = 0;
    public int diameterOfBinaryTree2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftMax = depth(root.left);
        int rightMax = depth(root.right);
        //该节点的最大深度
        int res = leftMax + rightMax;
        // 递归遍历 root.left 和 root.right 两个子树
        return Math.max(res, Math.max(diameterOfBinaryTree2(root.left), diameterOfBinaryTree2(root.right)));

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = depth(root.left);
        int rightMax = depth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

}