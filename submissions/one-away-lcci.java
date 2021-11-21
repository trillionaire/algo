class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }
        if (first.length() - second.length() > 1) {
            return false;
        }
        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();
        int diff = 0;
        boolean canDel = (chars1.length != chars2.length);
        for (int p1 = 0, p2 = 0; p1 < chars1.length && p2 < chars2.length; ) {
            if (chars1[p1] != chars2[p2]) {
                if (canDel) {
                    canDel = false;
                    p1++;
                    diff++;
                    continue;
                }
                if (++diff > 1) {
                    return false;
                }
            }
            p1++;
            p2++;
        }
        return true;
    }

}