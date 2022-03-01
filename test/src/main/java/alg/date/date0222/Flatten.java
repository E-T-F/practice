package alg.date.date0222;

import alg.date.date0221.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class Flatten {

    //分解子问题的思路
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        //后序位置，左右子树已经拉平
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode r = root;
        while (r.right != null) {
            r = r.right;
        }
        r.right = right;
    }


    //通过遍历一遍二叉树的思路
    List<TreeNode> preOrder = new ArrayList<>();
    public void flatten2(TreeNode root) {

        traversePreOrder(root);
        for (int i = 0; i < preOrder.size(); i++) {
            TreeNode node = preOrder.get(i);
            node.left = null;
            node.right = (i + 1) < preOrder.size() ? preOrder.get(i + 1) : null;

        }
    }

    private void traversePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder.add(root);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

}
