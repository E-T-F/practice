package alg.SwordOffer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class VerifyPostorder {


    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int cur1 = start;
        while (postorder[cur1] < postorder[end]) {
            cur1++;
        }
        int cur2 = cur1;
        while (postorder[cur2] > postorder[end]) {
            cur2++;
        }
        return (end == cur2) && recur(postorder, start, cur1 - 1) && recur(postorder, cur1, cur2 - 1);
    }

}
