class Solution {
    public int titleToNumber(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int res = 0;
        int carrier = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) { carrier = 1; }
            else { carrier *= 26; }
            res += (arr[len - i - 1] - 'A' + 1) * carrier; 
        }
        return res;
    }
}