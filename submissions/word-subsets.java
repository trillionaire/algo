class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] freq = new int[26];
        for (String s : B) {
            int[] cFreq = getFreq(s);
            freq = calFreq(freq, cFreq);
        }
        List<String> res = new ArrayList();
        for (String s: A) {
            int[] cFreq = getFreq(s);
            if (isCommon(freq, cFreq)) {
                res.add(s);
            }
        }
        return res;
    }

    private int[] getFreq(String s) {
        int[] freq = new int[26];
        for (Character c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    private int[] calFreq(int[] freq, int[] cFreq) {
        int[] res = new int[26];
        for (int i = 0; i < freq.length; i++) {
            res[i] = Math.max(freq[i], cFreq[i]);
        }
        return res;
    }

    private boolean isCommon(int[] freq, int[] cFreq) {
        for (int i = 0; i < freq.length; i++) {
            if (cFreq[i] < freq[i]) {
                return false;
            }
        }
        return true;
    }
}