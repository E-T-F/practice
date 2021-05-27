package ds.dp.dp_rob;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 */
public class Rob3 {

    Map<TreeNode, Integer> existed = new HashMap<>();
    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (existed.containsKey(root)) {
            return existed.get(root);
        }
        int do_rob = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int not_do_rob = rob(root.left) + rob(root.right);

        int max =  Math.max(do_rob, not_do_rob);
        existed.put(root, max);

        return max;
    }




    Map<TreeNode, Integer> do_rob = new HashMap<>();
    Map<TreeNode, Integer> no_rob = new HashMap<>();

    public int rob2(TreeNode root) {
        dfs(root);
        return Math.max(do_rob.getOrDefault(root, 0), no_rob.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        do_rob.put(root, root.val + no_rob.getOrDefault(root.left, 0) + no_rob.getOrDefault(root.right, 0));
        no_rob.put(root, Math.max(do_rob.getOrDefault(root.left, 0), no_rob.getOrDefault(root.left, 0))
                + Math.max(do_rob.getOrDefault(root.right, 0), no_rob.getOrDefault(root.right, 0)));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}