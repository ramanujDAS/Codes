/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
       Queue<ListNode> pq = new PriorityQueue<>((a , b) -> (a.val - b.val));

       for(ListNode node : lists){

        while(node != null){
            pq.add(node);
            node = node.next;
        }
       }

       ListNode root = new ListNode();
       ListNode temp = new ListNode();
       temp = root;
       while(!pq.isEmpty()){
          ListNode current = pq.remove();
          temp.next = new ListNode(current.val);
          temp = temp.next;

       }

       return root.next;

    }
}