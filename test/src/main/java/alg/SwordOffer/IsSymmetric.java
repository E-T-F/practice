package alg.SwordOffer;

/**
 * @Auther: etf
 * @Date: 2021-03-08 21:57
 * @Description:
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left ==  null && right == null) {
            return true;
        }


        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
