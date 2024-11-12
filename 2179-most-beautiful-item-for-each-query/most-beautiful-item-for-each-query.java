class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

      int [] ans = new int[queries.length];  
      Arrays.sort(items , ((a,b)->( a[0] - b[0] )));
      
     int max = items[0][1];
      for( int  i = 0 ;i <items.length ;i++){
          max = Math.max(items[i][1] , max);
          items[i][1] = max ;
      }
     
      for( int i =0 ;i < queries.length ; i++){
          ans[i] = binary(items , queries[i]);
      }

     return ans;

        
    }

    int binary(int [][] items , int num){

       int low  = 0;
       int high = items.length -1;
       int max =  0 ;
       while( low <= high){

         int mid = (low + high)/2;

         if(items[mid][0] <= num ){
             low = mid +1;
             max = Math.max(max , items[mid][1]);
         }else{
            high = mid -1;
         }
       }
     return max; 
    }
}