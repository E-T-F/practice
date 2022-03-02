package alg.date.Feb.date0223;

import alg.date.Feb.date0221.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KthSmallest {

    Map<TreeNode, Integer> nodeNum = new HashMap<>();
    public int kthSmallest(TreeNode root, int k) {
        calculateNodeNum(root);
        while (root != null) {
            int left = nodeNum.getOrDefault(root.left, 0);
            if (left == k - 1) {
                return root.val;
            } else if (left > k - 1) {
                root = root.left;
            } else if (left < k - 1) {
                root = root.right;
                k = k - (left + 1);
            }
        }
        return 0;
    }

    /**
     * 统计以 root 为根结点的子树的结点数
     * @param root
     * @return
     */
    private int calculateNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateNodeNum(root.left);
        int right = calculateNodeNum(root.right);
        nodeNum.put(root, 1 + left + right);
        return nodeNum.get(root);
    }

    int rank = 0;
    int res;

    public int kthSmallest2(TreeNode root, int k) {

        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        //中序位置
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);

    }

}
