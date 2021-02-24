package ds.tree;

import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class buildTree {

    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildMyTree(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildMyTree(int[] preorder, int pl, int pr,
                                 int[] inorder, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int orderIndex = inMap.get(preorder[pl]);
        root.left = buildMyTree(preorder, pl + 1, pl + orderIndex - il,
                inorder, il, orderIndex - 1);

        root.right = buildMyTree(preorder, pl + orderIndex - il + 1, pr,
                inorder, orderIndex + 1, ir);
        return root;
    }

    private TreeNode buildMyTree(int[] preorder, int rootIndex, int left, int right) {

        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int inorderIndex = inMap.get(preorder[rootIndex]);
        root.left = buildMyTree(preorder, rootIndex + 1, left, inorderIndex - 1);
        root.right = buildMyTree(preorder, rootIndex + (inorderIndex - left + 1), inorderIndex + 1, right);
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