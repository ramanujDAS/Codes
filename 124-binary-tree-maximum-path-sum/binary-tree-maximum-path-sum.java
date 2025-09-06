/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        int x = maxSum;
        maxSum = Integer.MIN_VALUE;
        return x;

    }

    private int pathSum(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);

        int sum = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        maxSum = Math.max(
                maxSum, Math.max(root.val,
                        Math.max(root.val + leftSum,
                        Math.max(root.val + rightSum,
                        root.val + leftSum + rightSum)))
                        );
        return sum;
    }
}