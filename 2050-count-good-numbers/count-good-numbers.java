class Solution {
    int mod = 1000000000 + 7;

    public int countGoodNumbers(long n) {
        long ans = 1;

        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;
        int evenOptions = 5;
        int oddOptions = 4;

        ans = ans * power(5, evenPos);
        ans = ans * power(4, oddPos);
        return (int) (ans % mod);
    }

    private long power(long base, long pow) {
        long res = 1;
        base = base % mod;
        while (pow > 0) {
            if (pow % 2 != 0) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            pow /= 2;
        }

        return res;
    }
}