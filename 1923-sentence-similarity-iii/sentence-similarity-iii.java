class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        
        Deque<String> deq1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> deq2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));

        while( !deq1.isEmpty() && 
                !deq2.isEmpty() &&
                deq1.peek().equals(deq2.peek())
                ){
                    deq1.poll(); 
                    deq2.poll();
                }
        while(!deq1.isEmpty() &&
               !deq2.isEmpty() &&
               deq1.peekLast().equals(deq2.peekLast())){
                deq1.pollLast();
                deq2.pollLast();
               }  

           return deq1.isEmpty()|| deq2.isEmpty();           
    }
}