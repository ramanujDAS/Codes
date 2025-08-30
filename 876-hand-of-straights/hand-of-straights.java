class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0)
           return false;

        Queue<Integer> pq = new PriorityQueue<>();

        for( int val : hand){
            pq.add(val);
        }   

        while(!pq.isEmpty()){
            int startNum = pq.remove();

            for(int i = 1; i<groupSize ;i++){
                if(pq.remove(startNum + i)){
                   continue; 
                }
                return false;

            }
        }
       return true; 
    }
}