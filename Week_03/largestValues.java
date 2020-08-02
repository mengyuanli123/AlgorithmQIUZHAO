import java.util.*;

/**
 515. 在每个树行中找最大值
 您需要在二叉树的每一行中找到最大的值。

 示例：

 输入:

 1
 / \
 3   2
 / \   \
 5   3   9

 输出: [1, 3, 9]
 */
public class largestValues {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> valList = new ArrayList<Integer>();

        if (root == null) {
            return valList;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {

            int queueSize = nodeQueue.size();

            int[] layerArray = new int[queueSize];

            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = nodeQueue.poll();
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }

                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
                layerArray[i] = cur.val;
            }
            Arrays.sort(layerArray);
            valList.add(layerArray[layerArray.length-1]);

        }
        return valList;
    }
}
