class Solution {
    public String maxValue(String n, int x) {
        boolean isNeg = (n.charAt(0) == '-');
        n = isNeg ? n.substring(1) : n;

        if (isNeg) {
            int pos = -1;
            for (int i = 0; i < n.length(); i++) {
                int cur = n.charAt(i) - '0';
                if (cur > x) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                pos = n.length();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("-").append(n.substring(0, pos)).append(x).append(n.substring(pos, n.length()));
            return sb.toString();
        }

        int pos = -1;
        for (int i = 0; i < n.length(); i++) {
            int cur = n.charAt(i) - '0';
            if (cur < x) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            pos = n.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n.substring(0, pos)).append(x).append(n.substring(pos, n.length()));
        return sb.toString();
    }
}