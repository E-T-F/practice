package alg.date.date0223;

import alg.date.date0221.TreeNode;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        Integer index = getMax(nums, start, end);
        if (index == null) {
            return null;
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = construct(nums, start, index);
        node.right = construct(nums, index + 1, end);

        return node;
    }

    /**
     * 左开右闭
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private Integer getMax(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int index = start;
        int num = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] > num) {
                num = nums[i];
                index = i;
            }
        }
        return index;

    }


}
