package alg.tree;

/**
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoh1zg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Auther: etf
 * @Date: 2022-01-13 00:03
 * @Description:
 */
public class MaxDepth {

    int answer = 0;
    public int maxDepth(TreeNode root) {
        traversal(root, 1);
        return answer;
    }

    private void traversal(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        traversal(root.left, depth + 1);
        traversal(root.right, depth + 1);
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
    }


    /**
     * 自底向上
     * 左子树为l，右子树为r，根结点为 max(l, r) + 1
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_depth = maxDepth2(root.left);
        int right_depth = maxDepth2(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }
}
