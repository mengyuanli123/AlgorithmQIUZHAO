import java.util.*;

/**
 102. 二叉树的层序遍历
 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 示例：
 二叉树：[3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 */
public class levelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> solution1(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if(root == null)
            return resultList;

        List<Integer> layerNode = new ArrayList<Integer>();

        nodeQueue.offer(root);
        layerNode.add(root.val);

        int currentLayerNode = 1;
        int nextLayerNode = currentLayerNode;

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            currentLayerNode--;

            if(currentLayerNode == 0){
                resultList.add(layerNode);
                layerNode = new ArrayList<Integer>();
                currentLayerNode = nextLayerNode;
                nextLayerNode = 0;

            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                layerNode.add(node.left.val);
                nextLayerNode++;
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                layerNode.add(node.right.val);
                nextLayerNode++;
            }
        }
        return resultList;

    }


    public List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
