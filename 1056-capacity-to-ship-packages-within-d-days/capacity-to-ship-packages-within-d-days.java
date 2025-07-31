class Solution {
    static {
        for (int i = 0; i < 500; i++)
            shipWithinDays(new int[0], 1);
    }

    public static int shipWithinDays(int[] weights, int d) {
        int low = 1;
        int high = 0;
        int shipMin = Integer.MAX_VALUE;

    
        for (int weight : weights) {
            high += weight;
            low = Math.max(low, weight);
        }
        int total = high;
        high = low * (int) Math.ceil((double) weights.length / d);
        low = Math.max(low, total / d);
   

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int days = noOfDays(weights, mid);
            if (days <= d) {
                high = mid - 1;
                shipMin = Math.min(mid, shipMin);
            } else {
                low = mid + 1;
            }

        }

        return shipMin;
    }

    private static int noOfDays(int[] weights, int capacity) {

        int noOfDays = 0;
        int totalWeight = 0;
        for (int w : weights) {
            totalWeight += w;
            if (totalWeight > capacity) {
                totalWeight = w;
                noOfDays++;
            }

        }
        return noOfDays + 1;
    }

}