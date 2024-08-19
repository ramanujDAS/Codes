class Solution {
    public int orangesRotting(int[][] grid) {

     Queue<Pair> q= new LinkedList<Pair>();
     int n= grid.length;
     int m= grid[0].length;

     int[][] visited= new int[n][m];
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2)q.add(new Pair(i,j));
        }
     }
     int time=0;

      int [][] index = {{1,0},{-1,0},{0,1},{0,-1}};
      while(q.size()>0){
        int sz= q.size();
        boolean flag=false;
        for(int j=0;j<sz;j++){
          Pair p = q.poll();
          
          for(int i=0;i<4;i++){
           int x= p.i+ index[i][0];
           int y= p.j+ index[i][1];
           if(x<0 || x>=n || y<0||y>=m || grid[x][y]==2 || grid[x][y]==0)continue;
           grid[x][y]=2;
           flag=true;
           q.add(new Pair(x,y));
        }
       
        }
       if(flag)time++;
      }  
     
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1)return -1;
        }
     }
  return time;

    }



   class Pair{
    public int i;
    public int j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
   } 
}