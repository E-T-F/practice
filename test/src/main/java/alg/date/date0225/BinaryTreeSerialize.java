package alg.date.date0225;

import alg.date.date0221.TreeNode;

import java.util.LinkedList;

public class BinaryTreeSerialize {

    private StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        traverse(root);
        return sb.toString();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            sb.append("#_");
            return;
        }
        sb.append(root.val).append("_");
        traverse(root.left);
        traverse(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split("_");
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : res) {
            if (s.equals("#")) {
                nodes.add(null);
            } else {
                nodes.add(s);
            }
        }
        //通过前序列表构造二叉树
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        String rootVal = nodes.removeFirst();
        if (rootVal == null) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
