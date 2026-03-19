class Solution {
    public void rotate(int[][] matrix) {

        int matLength = matrix.length;

        int top = 0;
        int bottom = matLength - 1;

        while (top < bottom) {

            for (int col = 0; col < matrix[0].length; col++) {
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;
            }
            top++;
            bottom--;
        }

        for (int row = 0; row < matLength; row++) {
            for (int col = row; col < matLength; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

    }
}