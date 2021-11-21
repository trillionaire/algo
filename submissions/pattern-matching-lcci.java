class Solution {
    // 数学：求方程aCnt * aLen + bCnt * bLen == value.length. 
    // 分支：pattern空，value空，单模式，双模式（a/b长度可能为空）
    public boolean patternMatching(String pattern, String value) {
        // pattern空
        if (pattern.isEmpty()) {
            return value.isEmpty();
        }
        // [aCnt, bCnt]
        int[] pCnt = getCnts(pattern);
        int aCnt = pCnt[0];
        int bCnt = pCnt[1];
        // value空：只能有a或b
        if (value.isEmpty()) {
            return aCnt == 0 || bCnt == 0;
        }
        // 单模式：全a或b
        if (isSinglePattern(aCnt, bCnt)) {
            return getSinglePatternResult(value, aCnt, bCnt);
        }
        // 双模式: 遍历aCnt，依次检查
        return getDoublePatternsResult(pattern, value, aCnt, bCnt);
    }

    private boolean getDoublePatternsResult(String pattern, String value, int aCnt, int bCnt) {
        for (int aLen = 0; aLen <= value.length() / aCnt; aLen++) {
            if (((value.length() - aCnt * aLen) % bCnt) == 0) {
                int bLen = (value.length() - aCnt * aLen) / bCnt;
                if (check(pattern, value, aCnt, aLen, bCnt, bLen)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean getSinglePatternResult(String value, int aCnt, int bCnt) {
        if (aCnt == 0 && bCnt == 0) {
            return false;
        }
        if (aCnt == 0) {
            return check(value, bCnt);
        }
        return check(value, aCnt);
    }

    private boolean isSinglePattern(int aCnt, int bCnt) {
        return aCnt == 0 || bCnt == 0;
    }

    private int[] getCnts(String pattern) {
        int[] pCnt = new int[2];
        for (int i = 0; i < pattern.length(); i++) {
            pCnt[pattern.charAt(i) - 'a'] += 1;
        }
        return pCnt;
    }

    private boolean check(String pattern, String value, int aCnt, int aLen, int bCnt, int bLen) {
        int aFirstIndex = pattern.indexOf('a') * bLen;
        int bFirstIndex = pattern.indexOf('b') * aLen;
        String a = value.substring(aFirstIndex, aFirstIndex + aLen);
        String b = value.substring(bFirstIndex, bFirstIndex + bLen);
        for (int i = 0, j = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                String curA = value.substring(j, j + aLen);
                j += aLen;
                if (!curA.equals(a)) {
                    return false;
                }
            }
            if (pattern.charAt(i) == 'b') {
                String curB = value.substring(j, j + bLen);
                j += bLen;
                if (!curB.equals(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(String value, int cnt) {
        if (value.length() % cnt != 0) {
            return false;
        }
        int len = value.length() / cnt;
        String b = value.substring(0, len);
        for (int i = 1; i < cnt; i++) {
            if (!value.substring(i * len, i * len + len).equals(b)) {
                return false;
            }
        }
        return true;
    }

}