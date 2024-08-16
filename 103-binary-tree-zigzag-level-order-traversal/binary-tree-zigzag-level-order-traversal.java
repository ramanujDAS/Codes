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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
           
       List<List<Integer>> ansList= new ArrayList<>();
      if(root == null) return ansList;
      Queue<TreeNode> q= new LinkedList<>();
      boolean level = true ;
      q.add(root);
      while(!q.isEmpty()){
        int sz= q.size();
        List<Integer> ansTemp= new ArrayList<>();
        for(int i=0;i<sz;i++){
            TreeNode node= q.poll();
           if(node.left != null) q.add(node.left);
            if(node.right !=null) q.add(node.right);
            ansTemp.add(node.val);
        }
      if(!level){
        Collections.reverse(ansTemp);
      }
      ansList.add(ansTemp); 

      level = !level; 
      }

return ansList; 
    }
}