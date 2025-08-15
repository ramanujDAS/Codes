class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
       
       // if(n == 1 || n == 2)return n; 
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int j = 0, i = 0;
        int ans = 0;
        while (j < n) {
            if (countMap.size() > 2) {
                int removed = fruits[i];
               
                countMap.put(fruits[i], countMap.get(fruits[i]) - 1);
                if (countMap.get(fruits[i]) == 0) {
                    countMap.remove(fruits[i]);
                }
            i++;
            }
            countMap.put(fruits[j], countMap.getOrDefault(fruits[j], 0) + 1);
            j++;

            if (countMap.size() <= 2 ) {
                int sum = 0;
                for (int count : countMap.values())
                    sum += count;

                ans = Math.max(sum, ans);
            }

        }

        return ans;
    }
}