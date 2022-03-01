package alg.date.date0226;

import alg.date.date0221.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {


    //节点 -> 父节点
    HashMap<TreeNode, TreeNode> parentMapping = new HashMap<>();
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        //存储访问的祖先集合
        HashSet<TreeNode> visited = new HashSet<>();
        while (p != null) {
            visited.add(p);
            p = parentMapping.get(p);
        }
        while (q != null) {
            //已访问过
            if (visited.contains(q)) {
                return q;
            }
            q = parentMapping.get(q);
        }
        //不存在
        return null;
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMapping.put(root.left, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parentMapping.put(root.right, root);
            dfs(root.right);
        }
    }

    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    /**
     * 自底向上判断
     * root 是否包含 p 或者 q 节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lChild = dfs(root.left, p, q);
        boolean rChild = dfs(root.right, p, q);

        // 1. root 的 lChild、rChild 返回true，则为 true
        // 2. lChild、rChild 一个为 true, 且 root 为 p 或者 q
        if ((lChild && rChild) || (root.val == p.val || root.val == q.val && (lChild || rChild))) {
            res = root;
        }
        return lChild || rChild || root.val == p.val || root.val == q.val;
    }

    /**
         * 所有 Node.val 互不相同
         * p != q
         * p 和 q 均存在于给定的二叉树中。
         */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        //root本身就是p或者q，比如说root就是p节点吧，如果q存在于以root为根的树中，显然root就是最近公共祖先；
        // 即使q不存在于以root为根的树中，按照情况 3 的定义，也应该返回root节点。 (如果p和q只有一个存在于root为根的树中,函数就会返回那个节点。
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        // p、q分别在左右子树，返回 root
        if (left != null && right != null) {
            return root;
        }

        //left、right其中一个不为null
        return left == null ? right : left;
    }
}
