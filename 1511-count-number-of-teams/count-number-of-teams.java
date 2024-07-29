class Solution {
    public int numTeams(int[] rating) {
    int r = 0 ;
       for(int i = 0 ;i < rating.length ;i++){
          for(int j=0; j < i ; j++){
            for(int k =0 ;k<j ;k++){
                if((rating[i] < rating[j] && rating[j] < rating[k]) ||(rating[i]> rating[j] && rating[j]>rating[k]))
                  r++;
                    

            }
          }

       }
       return r; 
    }
}