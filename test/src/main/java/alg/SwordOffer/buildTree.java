package alg.SwordOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class buildTree {
    Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd,
                               int[] inorder, int iStart, int iEnd) {

        if (pStart > pEnd) {
            return null;
        }
        //根结点
        TreeNode root = new TreeNode(preorder[pStart]);
        //中序遍历中根结点的index
        int inOrderRoot = inOrderMap.get(preorder[pStart]);
        //左子树的结点个数
        int left_subTree_size = inOrderRoot - iStart;
        //左边为左子树
        root.left = buildTree(preorder, pStart + 1, pStart + left_subTree_size,
                inorder, iStart, inOrderRoot - 1);
        //右边为右子树
        root.right = buildTree(preorder, pStart + left_subTree_size + 1, pEnd,
                inorder, inOrderRoot + 1, iEnd);

        return root;
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