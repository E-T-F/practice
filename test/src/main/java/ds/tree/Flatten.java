package ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }


    //前序遍历
    List<TreeNode> list = new ArrayList<>();
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalPre(root);

        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            if (i + 1 < list.size()) {
                node.right = list.get(i + 1);
            }
        }
    }

    private void traversalPre(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        traversalPre(root.left);
        traversalPre(root.right);
    }
}
