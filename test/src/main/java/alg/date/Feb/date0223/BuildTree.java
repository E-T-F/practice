package alg.date.Feb.date0223;

import alg.date.Feb.date0221.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class    BuildTree {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        if (preorder.length <= 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildTreeWithPreInOrder(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeWithPreInOrder(int[] preorder, int preStart, int preEnd,
                                             int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inOrderIndexMap.get(rootVal);
        //左子树节点数量
        int left_size = inorderIndex - inStart;
        root.left = buildTreeWithPreInOrder(preorder, preStart + 1, preStart + left_size,
                inorder, inStart, inorderIndex - 1);
        root.right = buildTreeWithPreInOrder(preorder, preStart + 1 + left_size, preEnd,
                inorder, inorderIndex + 1, inEnd);
        return root;
    }


    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     * <p>
     * 示例 1:
     * <p>
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length <= 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return buildTreeWithInPostOrder(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);

    }

    private TreeNode buildTreeWithInPostOrder(int[] inorder, int inStart, int inEnd,
                                              int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inOrderIndex = inOrderIndexMap.get(rootVal);
        int leftSize = inOrderIndex - inStart;
        root.left = buildTreeWithInPostOrder(inorder, inStart, inOrderIndex - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = buildTreeWithInPostOrder(inorder, inOrderIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }


    /**
     * 889. 根据前序和后序遍历构造二叉树
     * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
     * <p>
     * 如果存在多个答案，您可以返回其中 任何 一个。
     * <p>
     * 示例 1：
     * <p>
     * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     *
     * @param preorder
     * @param postorder
     * @return
     */
    Map<Integer, Integer> postOrderIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        if (preorder.length <= 0) {
            return null;
        }
        for (int i = 0; i < postorder.length; i++) {
            postOrderIndexMap.put(postorder[i], i);
        }
        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd,
                                          int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];

        int leftRootVal = preorder[preStart + 1];
        int leftRootIndexForPostOrder = postOrderIndexMap.get(leftRootVal);
        int leftSize = leftRootIndexForPostOrder - postStart + 1;
        TreeNode node = new TreeNode(rootVal);
        node.left = constructFromPrePost(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, leftRootIndexForPostOrder);
        node.right = constructFromPrePost(preorder, preStart + 1 + leftSize, preEnd,
                postorder, leftRootIndexForPostOrder + 1, postEnd - 1);

        return node;
    }
}
