class Solution {
    int max = 0;

    Integer[][][][] memo;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        memo = new Integer[n][n][n][n];
        return Math.max(0, cherryPickup(grid, 0, 0, 0, 0));

    }

    private int cherryPickup(int[][] grid, int r1, int c1, int r2, int c2) {

        if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }

        if (memo[r1][c1][r2][c2] != null) {
            return memo[r1][c1][r2][c2];
        }

        int cherry = 0;

        if (r1 == r2 && c1 == c2) {
            cherry += grid[r1][c1];
        } else {
            cherry += grid[r1][c1] + grid[r2][c2];
        }

        int bothRight = cherryPickup(grid, r1 + 1, c1, r2 + 1, c2); // both in right direction
        int bothDown = cherryPickup(grid, r1, c1 + 1, r2, c2 + 1); // both in down direction
        int rightDown = cherryPickup(grid, r1, c1 + 1, r2 + 1, c2); // one right direction and second down direction
        int downRight = cherryPickup(grid, r1 + 1, c1, r2, c2 + 1); // one down and second right direction

        cherry += Math.max(Math.max(bothRight, bothDown), Math.max(rightDown, downRight));
        memo[r1][c1][r2][c2] = cherry;
        return memo[r1][c1][r2][c2] ;


    }

    public void TopToBottom(int[][] grid, int i, int j, int totalCount) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            bottomUp(grid, i, j, totalCount);
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        TopToBottom(grid, i + 1, j, totalCount + temp);
        TopToBottom(grid, i, j + 1, totalCount + temp);
        grid[i][j] = temp;
    }

    public void bottomUp(int[][] grid, int i, int j, int totalCount) {
        if (i < 0 || j < 0 || grid[i][j] == -1) {
            return;
        }
        if (i == 0 && j == 0) {
            totalCount += grid[i][j];
            max = Math.max(max, totalCount);
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        bottomUp(grid, i - 1, j, totalCount + temp);
        bottomUp(grid, i, j - 1, totalCount + temp);
        grid[i][j] = temp;
    }

}