package alg.date.Feb.date0221;

import java.util.LinkedList;
import java.util.List;

public class TraverseTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        traversePreOrder(root);
        System.out.println("---------");
        traversePostOrder(root);

    }

    public static List<Integer> res = new LinkedList<>();
    private static void traversePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        res.add(root.val);
    }

    private static void traversePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }
}
