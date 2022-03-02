package alg.date.Feb.date0221;

import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

    /**
     * 分解问题计算答案的思路
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int leftMax = maxDepth(root.left);

        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }

    /**
     * 遍历二叉树计算答案的思路
     *
     * @param root
     * @return
     */

    //结果
    private int res = 0;
    //遍历到节点的深度
    private int depth = 0;

    public int maxDepth2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    private void traverse(TreeNode root) {
        if (root == null) {
            //叶子节点计算更新
            res = Math.max(res, depth);
            return;
        }
        //前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        //后序位置
        depth--;
    }

    public int maxDepth3(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
        return res;

    }
}