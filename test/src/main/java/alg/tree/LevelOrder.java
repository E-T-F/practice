package alg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: etf
 * @Date: 2022-01-12 23:15
 * @Description:
 */
public class LevelOrder {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left !=null) {
                    queue.offer(node.left);
                }
                if (node.right !=null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
    }
}
