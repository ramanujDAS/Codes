class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        List<int[]> events = new ArrayList<>();
          for (int i = 0; i < times.length; i++) {
            events.add(new int[] { times[i][0], i }); // Friend arrives
            events.add(new int[] { times[i][1], ~i }); // Friend leaves
        }

        Collections.sort(events, (a,b)-> a[0] - b[0]) ;

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a,b)->a[0] - b[0]);

        for(int i=0;i<times.length ;i++){
            availableChairs.add(i);
        }

        for(int [] event : events){
            int time = event[0];
            int friendIndex = event[1];

            while(!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time){
                availableChairs.add(occupiedChairs.poll()[1]);
            }

            if(friendIndex >= 0){
                int chair  = availableChairs.poll();
                if(friendIndex == targetFriend) return chair ;


                occupiedChairs.add(new int[]{times[friendIndex][1],chair});
            }



        }


      return -1;
    }
}