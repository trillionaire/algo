class Solution {
    public String getHint(String secret, String guess) {
        int[] sfreq = new int[10];
        int[] gfreq = new int[10];
        int bulls = 0;
        int cows = 0;
        char[] schars = secret.toCharArray();
        char[] gchars = guess.toCharArray();
        for (int i = 0; i < schars.length; i++) {
            if (schars[i] == gchars[i]) { bulls++; continue; }
            sfreq[schars[i] - '0']++;
            gfreq[gchars[i] - '0']++;
        }

        for (int i = 0; i < sfreq.length; i++) {
            cows += Math.min(sfreq[i], gfreq[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }
}