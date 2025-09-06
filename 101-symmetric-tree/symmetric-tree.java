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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) 
           return true;

        return isMirror(root.left , root.right);   

    }

    private boolean isMirror(TreeNode leftRoot , TreeNode rightRoot ){
        
       if(rightRoot == null && leftRoot == null)
          return true;
       if(rightRoot == null || leftRoot == null)
          return false;

       if(rightRoot.val != leftRoot.val)
          return false;       
       
       boolean isLeftMirror = isMirror(leftRoot.left ,rightRoot.right);
       boolean isRightMirror = isMirror(leftRoot.right , rightRoot.left);

       return isLeftMirror && isRightMirror;

    }
}