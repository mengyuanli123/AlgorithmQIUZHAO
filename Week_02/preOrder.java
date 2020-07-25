import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 144. 二叉树的前序遍历
 给定一个二叉树，返回它的 前序 遍历。
 */

public class preOrder {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
  }

    public List<Integer> solution1(TreeNode root) {

         List<Integer> nodeVal = new ArrayList<Integer>();
         recursion(root,nodeVal);
         return nodeVal;
    }

    private void recursion(TreeNode root,List<Integer> nodeVal){

        if (root != null) {
            nodeVal.add(root.val);

            if (root.left != null) {
                recursion(root.left, nodeVal);
            }

            if(root.right != null) {
                recursion(root.right, nodeVal);
            }
        }
    }

    public List<Integer> solution2(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> resList = new ArrayList<Integer>();

        TreeNode currentNode = root;
        nodeStack.push(currentNode);

        if (root == null)
            return resList;

        while (!nodeStack.isEmpty()) {

            currentNode = nodeStack.pop();
            resList.add(currentNode.val);
            if (currentNode.right != null)
                nodeStack.push(currentNode.right);

            if (currentNode.left != null)
                nodeStack.push(currentNode.left);
        }

        return resList;
    }
}
