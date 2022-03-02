package alg.date.Feb.date0224;

import alg.date.Feb.date0221.TreeNode;

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
