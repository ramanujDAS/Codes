class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int n = values.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b -a );
        int maxScore = 0;
        for( int i = 0 ;i < n; i++){
            
            if(!pq.isEmpty()){
                maxScore = Math.max( maxScore , pq.peek() + values[i] - i);
            }
            pq.add(values[i] + i);

        }
        return maxScore;
    }
}