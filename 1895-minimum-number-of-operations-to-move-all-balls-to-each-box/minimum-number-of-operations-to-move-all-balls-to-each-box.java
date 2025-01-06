class Solution {
    public int[] minOperations(String boxes) {

    int n = boxes.length();
    
    int [] res = new int[n];
    int [] prefix = new int[n];
    int currentBalls = boxes.charAt(0) - '0' ;
    for(int i = 1 ;i < boxes.length() ;i++){
        prefix[i] = prefix[i - 1] + currentBalls;
        currentBalls += boxes.charAt(i) - '0';

    }
       for (int i = 0; i < n; i++) {
            res[i] = res[i] + prefix[i];
        }
      
       Arrays.fill(prefix ,  0);
        int balls = boxes.charAt(n-1) - '0'; 
        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = prefix[i + 1] + balls;
            balls += boxes.charAt(i) - '0'; 
        }
      
       for (int i = 0; i < n; i++) {
            res[i] = res[i] + prefix[i];
        }
      
      return res;

    }
}