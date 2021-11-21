class Solution {
    public int minCharacters(String a, String b) {
        int[] aCountMap = count(a);
        int[] bCountMap = count(b);
        int res = getSameCount(aCountMap, bCountMap);
        res = Math.min(res, getFirstCount(aCountMap, bCountMap));
        res = Math.min(res, getFirstCount(bCountMap, aCountMap));
        return res;
    }
    
    // greed
    private int getFirstCount(int[] a, int[] b) {
        int count = 0;
        int res = Integer.MAX_VALUE;
        // for every char [a-y], get count for a <= i and b > i
        for (int i = 0; i < 25; i++) {
            count = getCount(a, i, true);
            count += getCount(b, i, false);
            res = Math.min(res, count);
        }
        return res;
    }

    private int getCount(int[] a, int pos, boolean isSmall) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (isSmall && (i <= pos)) {
                res += a[i];
            }
            if (!isSmall && (i > pos)) {
                res += a[i];
            }
        }
        return res;
    }

    private int getSameCount(int[] a, int[] b) {
        int total = 0;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            total += a[i];
            total += b[i];
            max = Math.max(max, a[i] + b[i]);
        }
        return total - max;
    }

    private int[] count(String a) {
        int[] res = new int[26];
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res[chars[i] - 'a'] += 1;
        }
        return res;
    }

}