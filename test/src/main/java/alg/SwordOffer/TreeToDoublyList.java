package alg.SwordOffer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 * @Auther: etf
 * @Date: 2021-03-12 22:03
 * @Description:
 */
public class TreeToDoublyList {

    Node pre, head;
    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }
        //二叉搜索树 中序遍历 即为 从小到大

        dfs(root);
        //递归完 pre 指向最后一个节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        //构建
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}




// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}