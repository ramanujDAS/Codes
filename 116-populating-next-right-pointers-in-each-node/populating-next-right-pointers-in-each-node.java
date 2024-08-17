/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       fun(root);
       return root; 
    }
   void fun(Node root){
     if(root == null || root.left == null) return ;

    if(root.left != null) root.left.next = root.right ;

     fun(root.left) ;

     if(root.next != null){
        root.right.next = root.next.left ;
     }
     fun(root.right);

   }

}