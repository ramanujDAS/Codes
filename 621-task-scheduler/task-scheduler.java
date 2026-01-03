class Solution {
    public int leastInterval(char[] tasks, int n) {

     int[] freq = new int[26];

     for(char ch : tasks){
        freq[ch - 'A']++;
     }   

     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

     for(int i = 0; i<26 ;i++){
        if(freq[i] > 0)
           pq.add(freq[i]);
     }

     int ansTime = 0;

     while(!pq.isEmpty()){
        int cycle = n + 1;
        List<Integer> stored = new ArrayList<>();
        int taskExecuted = 0;

        while(cycle-- > 0 && !pq.isEmpty()){
            int currentFreq = pq.poll();
            if(currentFreq > 1){
                stored.add(currentFreq - 1);
            }
            taskExecuted++;
        } 
        ansTime += n+1;
        for(int i = 0 ; i<stored.size() ;i++){
            pq.add(stored.get(i));
        }
        if(pq.isEmpty()){
            ansTime -= n+1;
            ansTime +=taskExecuted;
        }
     } 

    return ansTime;
    }
}