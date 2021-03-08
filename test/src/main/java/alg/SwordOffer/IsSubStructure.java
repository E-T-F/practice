package alg.SwordOffer;

import java.util.LinkedList;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 */
public class IsSubStructure {

    public boolean isSubStructure2(TreeNode A, TreeNode B) {

        return  (A != null && B != null)
                && (isSub2(A, B) || isSubStructure2(A.left, B) || isSubStructure2(A.right, B));
    }

    private boolean isSub2(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }

        return isSub2(a.left, b.left) && isSub2(a.right, b.right);

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (A == null || B == null) {
            return false;
        }
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (isSub(temp, B)) {
                return true;
            }
            if (temp != null) {
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return false;
    }

    private boolean isSub(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }
        if (b == null) {
            return true;
        }
        if (a.val == b.val) {
            return isSub(a.left, b.left) && isSub(a.right, b.right);
        }

        return false;
    }
}
