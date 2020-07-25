import java.util.ArrayList;
import java.util.List;

/**
 589. N叉树的前序遍历
 给定一个 N 叉树，返回其节点值的前序遍历。
 */


public class nPreOrder {
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

    public List<Integer> preOrder(Node root) {
        List<Integer> nodeList = new ArrayList<Integer>();
        recursion(root, nodeList);
        return nodeList;
    }

    private void recursion(Node root, List<Integer> nodeList) {
        if (root != null) {
            nodeList.add(root.val);

            if (root.children != null) {
                for (Node childNode : root.children) {
                    recursion(childNode, nodeList);
                }
            }
        }
    }
}
