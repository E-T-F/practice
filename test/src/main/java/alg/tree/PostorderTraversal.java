package alg.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: etf
 * @Date: 2022-01-12 23:11
 * @Description:
 */
public class PostorderTraversal {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);
        traversal(root.right);
        res.add(root.val);
    }
}
