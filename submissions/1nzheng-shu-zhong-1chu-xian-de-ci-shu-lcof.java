class Solution {
    /*
    1234: p=1000, h=1, l=234.
      0-999: f(p-1)
      1000-1234: (l+1) + f(l) 
    3234: p=1000, h=3, l=234.
      0-999: f(p-1)
      1000-1999: f(p-1) + p
      2000-2999: f(p-1)
      3000-3234: f(l)
    */
    public int countDigitOne(int n) {
        if (n == 0) { return 0; }
        if (n < 10) { return 1; }
        int res = 0;
        int p = 1;
        int h = 0;
        int l = 0;
        int tmp = n;
        while (tmp >= 10) {
            p *= 10;
            tmp = tmp / 10;
        }
        h = n / p;
        l = n % p;
        if (h == 1) {
            return countDigitOne(p - 1) + countDigitOne(l) + l + 1;
        }
        return h * countDigitOne(p - 1) + countDigitOne(l) + p;
    }
}