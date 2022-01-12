package alg.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: etf
 * @Date: 2022-01-12 23:09
 * @Description:
 */
public class InorderTraversal {


    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }
}
