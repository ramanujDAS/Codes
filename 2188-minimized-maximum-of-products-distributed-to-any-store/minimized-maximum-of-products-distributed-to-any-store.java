class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        for (int num : quantities)
            high = Math.max(high, num);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canDistribute(n, quantities, mid)) {
                high = mid -1;
            } else {
                low = mid +1;
            }

        }
        return low;

    }

    boolean canDistribute(int n, int[] quantities, int x) {
        int store = 0;
        if (x == 0)
            return true;
        for (int quant : quantities) {
            store += quant / x;
            if (quant % x != 0)
                store++;
        }
        if (store > n)
            return false;
        return true;
    }
}