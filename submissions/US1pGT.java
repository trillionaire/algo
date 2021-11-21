class MagicDictionary {
    private Set<String> set;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        set = new HashSet();
    }

    public void buildDict(String[] dictionary) {
        set = Arrays.stream(dictionary).collect(Collectors.toSet());
    }

    public boolean search(String word) {
        for (String s : set) {
            if (compare(s, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */