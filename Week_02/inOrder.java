import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 94. 二叉树的中序遍历
 给定一个二叉树，返回它的中序 遍历。
 */

public class inOrder {

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
              if (root.left != null)
                  recursion(root.left, nodeVal);

              nodeVal.add(root.val);

              if (root.right !=null)
                  recursion(root.right, nodeVal);
         }
    }

    public List<Integer> solution2(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> resList = new ArrayList<Integer>();

        while (root != null || !nodeStack.isEmpty()) {

            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            resList.add(root.val);

            root = root.right;
        }
        return resList;
    }
}
