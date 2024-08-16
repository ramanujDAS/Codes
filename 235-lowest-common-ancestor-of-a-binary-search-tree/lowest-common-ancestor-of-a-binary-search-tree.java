/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return  fun(root,p,q);  
    }

    TreeNode fun(TreeNode root,TreeNode p,TreeNode q){
      
     //if(root == p || root == q) return root ;

      if(p.val < root.val && q.val < root.val){
       return fun(root.left,p,q);
      }
      else if(p.val> root.val && q.val > root.val){
       return fun(root.right ,p , q);
      }
      else return root;
   }
}