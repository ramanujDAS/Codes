class Solution {
    public int numTeams(int[] A) {

        int r = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int leftSmaller = 0;
            int rightGreater = 0;
            int leftGreater = 0;
            int rightSmaller = 0;

            for (int j = 0; j < n; j++) {

                if (A[j] < A[i]) {
                    if (j < i)
                        leftSmaller++;
                    else
                        rightSmaller++;
                }

                if (A[j] > A[i]) {
                    if (j < i)
                        leftGreater++;
                    else
                        rightGreater++;
                }

            }
            r += leftSmaller * rightGreater + leftGreater * rightSmaller;
        }
        return r;
    }
}