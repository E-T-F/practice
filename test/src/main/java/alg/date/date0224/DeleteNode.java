package alg.date.date0224;

import alg.date.date0221.TreeNode;

public class DeleteNode {

    /**
     * 450. 删除二叉搜索树中的节点
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
     * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            //删除节点
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }

            //左右子节点均不为null，删除该节点 需使用 左子树最大节点或者 右子树最小节点替换
            TreeNode minNode = getMin(root.right);
            //删除右子树对应节点
            deleteNode(minNode, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            return minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }


    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
