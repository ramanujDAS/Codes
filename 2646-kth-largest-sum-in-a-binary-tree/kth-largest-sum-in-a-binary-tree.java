/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int level = 0;

        while (queue.size() > 0) {
            int sz = queue.size();
            long sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode poppedNode = queue.poll();
                sum += poppedNode.val;
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }

                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }

            pq.add(sum);

        }
        long count = k - 1;
        while (count-- > 0) {
           // System.out.println(pq.peek());
            pq.poll();

        }
       if(pq.isEmpty()) return -1;
        return pq.peek();

    }
}