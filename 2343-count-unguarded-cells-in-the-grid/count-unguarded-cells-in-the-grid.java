class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][n];

        for (int i = 0; i < walls.length; i++) {
            grid[walls[i][0]][walls[i][1]] = -2;
        }

        for(int [] arr : guards){
            grid[arr[0]][arr[1]] = -1;
        }

        for (int i = 0; i < guards.length; i++) {

            markGuardsRight(grid, guards[i][0], guards[i][1] + 1 , 'R');
            markGuardsRight(grid, guards[i][0], guards[i][1] -1 , 'L');
            markGuardsRight(grid, guards[i][0] +1, guards[i][1] , 'T');
            markGuardsRight(grid, guards[i][0] -1, guards[i][1] ,'D');
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    ans++;
            }
        }

        return ans;
    }

    void markGuardsRight(int[][] grid , int i , int j , char direction){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == -2 || grid[i][j] == -1) return;

        grid[i][j] = -3 ; 

         switch(direction){
            case 'R' : markGuardsRight(grid , i , j + 1, 'R');
                        break;
            case 'L' : markGuardsRight(grid , i , j - 1 , 'L');
                         break;
            case 'T' : markGuardsRight(grid , i+1, j, 'T');
                         break;
            case 'D' : markGuardsRight(grid, i-1 , j , 'D');
                          break;
         }
       

    }

    
}