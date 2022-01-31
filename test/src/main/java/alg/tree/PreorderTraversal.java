package alg.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: etf
 * @Date: 2022-01-12 23:01
 * @Description:
 */
public class PreorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}
