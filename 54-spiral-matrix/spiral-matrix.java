class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> spiralList = new ArrayList<>();

        while (true) {
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                spiralList.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom)
                break;
            for (int i = right; i >= left; i--) {
                spiralList.add(matrix[bottom][i]);
            }

            bottom--;
            if (left > right || top > bottom)
                break;
            for (int i = bottom; i >= top; i--) {
                spiralList.add(matrix[i][left]);
            }
            if (left > right || top > bottom)
                break;
            left++;
        }

        return spiralList;
    }
}