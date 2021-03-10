package alg.SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *
 * @Auther: etf
 * @Date: 2021-03-09 23:13
 * @Description:
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                res.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
