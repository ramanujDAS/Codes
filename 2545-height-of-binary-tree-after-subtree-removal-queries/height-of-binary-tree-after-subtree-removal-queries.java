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
   private static final int [] maxHeightAfterRemoval = new int[100001];
   private int currentmaxHeight = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {

      traverseTree(root , 0);
      currentmaxHeight = 0 ;
     traverseTree1(root , 0);

      int [] queriesAns = new int[queries.length];

      for( int query = 0; query < queries.length ;query++){
        queriesAns[query] = maxHeightAfterRemoval[queries[query]];
      } 

      return queriesAns;


    }

    private void traverseTree(TreeNode node , int currentHeight){
        
        if(node == null) return;

        maxHeightAfterRemoval[node.val] =  currentmaxHeight;

        currentmaxHeight = Math.max(currentmaxHeight , currentHeight);

        traverseTree(node.left , currentHeight +1);
        traverseTree(node.right , currentHeight +1);   

    }

     private void traverseTree1(TreeNode node , int currentHeight){
        
        if(node == null) return;

        maxHeightAfterRemoval[node.val] = Math.max(maxHeightAfterRemoval[node.val], currentmaxHeight);

        currentmaxHeight = Math.max(currentmaxHeight , currentHeight);

        traverseTree1(node.right , currentHeight +1);
        traverseTree1(node.left , currentHeight +1);   

    }
}