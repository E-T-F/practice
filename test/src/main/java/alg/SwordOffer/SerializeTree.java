package alg.SwordOffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                res.append("null,");
            } else {
                res.append(temp.val).append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (!values[i].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(temp.left);
            }
            i++;
            if (!values[i].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(temp.right);
            }
            i++;
        }
        return root;
    }


    public String serializeWithRec(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serializeWithRec(root.left) + "," + serializeWithRec(root.right);
    }


    public TreeNode deserializeWithRec(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return recursion(queue);
    }

    private TreeNode recursion(LinkedList<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = recursion(queue);
        root.right = recursion(queue);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);
        System.out.println(new SerializeTree().serializeWithRec(root));
    }
}
