class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m =  n;
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ;i<triangle.size() ;i++){
            List<Integer> l = new ArrayList<>();
            for(int j =0 ;j<triangle.get(i).size() ;j++){
                l.add(-1);
            }
          list.add(l);
        }
        

        return getTotal(triangle,0,0,list);
    }

    int getTotal(List<List<Integer>> triangle , int i , int j,List<List<Integer>> dp){
       if(i == triangle.size()) return 0;

       if(dp.get(i).get(j)!= -1) return dp.get(i).get(j);
        
        int down = getTotal(triangle , i+1,j,dp);
        int downRight = getTotal(triangle,i+1,j+1,dp);

        int totalCost = triangle.get(i).get(j) + Math.min(down,downRight);
        dp.get(i).set(j,totalCost);
       return  dp.get(i).get(j);

    }
}