class Solution {
    public boolean backspaceCompare(String S, String T) {
        return formatstr(S).equals(formatstr(T));    
    }

    private String formatstr(String s) {
        StringBuilder sb = new StringBuilder();
        int sharp = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '#') { sharp++; continue; }
            if (sharp > 0) {
                sharp--;
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}