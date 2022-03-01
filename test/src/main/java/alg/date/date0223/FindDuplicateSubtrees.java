package alg.date.date0223;

import alg.date.date0221.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 */
public class FindDuplicateSubtrees {


    HashMap<String, Integer> memory = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return res;
        }

        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        //后序位置，可以获取前置结果
        String serialize = root.val + "_" + left + "_" + right;
        int frequency = memory.getOrDefault(serialize, 0);
        if (frequency == 1) {
            res.add(root);
        }
        memory.put(serialize, frequency + 1);
        return serialize;
    }

}
