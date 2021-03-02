package alg.SwordOffer;

import java.util.LinkedList;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * <p>
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 限制：0 <= 节点个数 <= 1000
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode mirrorRoot = new TreeNode(root.val);
        mirrorRoot.left = mirrorTree(root.right);
        mirrorRoot.right = mirrorTree(root.left);
        return mirrorRoot;
    }

    public TreeNode mirrorTreeWithBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }


    public TreeNode mirrorTreeWithDFS(TreeNode root) {

        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>() {{ add(root);}};
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

}