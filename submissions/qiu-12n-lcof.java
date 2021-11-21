class Solution {
    // 语法糖：赋值来绕过if
    public int sumNums(int n) {
        boolean tmp = (n > 1) && (n = sumNums(n - 1) + n) > 0;
        return n;
    }
}