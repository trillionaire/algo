class Solution {
    // 快速幂：取模
    public static final long MOD = (long)(1e9 + 7);
    public long comp(long n, long x) {
        if(n == 0) return 1L;
        long tmp = comp(n / 2, x);
        if(n % 2 == 0) { // 偶数时，求平方得f(n)
            return tmp * tmp % MOD; 
        }else {
            // 奇数多乘一个x，f(n/2) * f(n/2) * x
            return tmp * tmp * x % MOD; 
        }
    }
    public int countGoodNumbers(long n) {
        long x = (long)(n / 2);     // 求奇数个数
        long y = (long)(n - n / 2); // n - 奇数 = 偶数
        return (int)(comp(x, 4) * comp(y, 5) % MOD);
    }
}