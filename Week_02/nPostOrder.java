import java.util.ArrayList;
import java.util.List;

/**
 590. N叉树的后序遍历
 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class nPostOrder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postOrder(Node root) {

        List<Integer> nodeList = new ArrayList<Integer>();
        recursion(root, nodeList);
        return nodeList;

    }

    private void recursion(Node root, List<Integer> nodeList) {

        if (root!=null) {
            if (root.children != null) {
                for (Node child : root.children) {
                    recursion(child, nodeList);
                }
            }
            nodeList.add(root.val);
        }
    }
}
