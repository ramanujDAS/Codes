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
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> levelSum = new ArrayList<>();

        queue.add(root);
        while (queue.size() > 0) {

            int sz = queue.size();
            int sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    sum += current.left.val;
                    queue.add(current.left);

                }
                if (current.right != null) {
                    sum += current.right.val;
                    queue.add(current.right);
                }
            }
            levelSum.add(sum);
        }

        queue.add(root);
        int level = 0;
        while(queue.size() > 0){
            int sz = queue.size();
            
            for(int i = 0; i<sz ; i++){
                 int siblingSum = 0;
                TreeNode currentNode = queue.poll();
                
                    siblingSum = (currentNode.left != null ? currentNode.left.val : 0 )+ 
                                  (currentNode.right != null ? currentNode.right.val : 0); 

                if(currentNode.left != null){
                   int cousinSum = levelSum.get(level) - siblingSum ;
                   currentNode.left.val = cousinSum; 
                   queue.add(currentNode.left);
                }  

                if(currentNode.right != null){
                    int cousinSum = levelSum.get(level) - siblingSum ;
                   currentNode.right.val = cousinSum;  
                   queue.add(currentNode.right);
                }  
              

            
            }
          level++;  
        } 
     root.val =0;
      return root;
    }
}