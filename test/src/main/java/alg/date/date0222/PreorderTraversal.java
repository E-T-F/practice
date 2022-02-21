package alg.date.date0222;

import alg.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {


    /**
     * 通过分解子问题思路前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }


    /**
     * 通过遍历一遍二叉树思路解决
     */
    public List<Integer> res = new ArrayList<>();
    private void traversePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }
}
