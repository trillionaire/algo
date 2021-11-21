class Solution {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int pre = getVal(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int cur = getVal(chars[i]);
            if (pre < cur) {
                res -= pre;
            } else {
                res += pre;
            }
            pre = cur;
        }
        res += pre;
        return res;
    }
    private int getVal(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}