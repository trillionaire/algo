    class WordDictionary {
        // TRIE + DFS
        private Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.add(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }
    }

    class Trie {
        private Trie[] children;
        private boolean isLeaf;

        public Trie() {
            children = new Trie[26];
        }

        public void add(String word) {
            char[] chars = word.toCharArray();
            Trie iter = this;
            for (int i = 0; i < chars.length; i++) {
                if (iter.children[(int) (chars[i] - 'a')] == null) {
                    iter.children[(int) (chars[i] - 'a')] = new Trie();
                }
                iter = iter.children[(int) (chars[i] - 'a')];
            }
            iter.isLeaf = true;
        }

        // DFS
        public boolean search(String word) {
            if (word.length() == 0) {
                return isLeaf;
            }
            char[] chars = word.toCharArray();
            Trie iter = this;
            for (int i = 0; i < chars.length; i++) {
                String nextStr = String.valueOf(Arrays.copyOfRange(chars, i + 1, chars.length));
                if (chars[i] == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (iter.children[j] != null && iter.children[j].search(nextStr) == true) {
                            return true;
                        }
                    }
                    return false;
                } else if (iter.children[(int) (chars[i] - 'a')] == null) {
                    return false;
                } else {
                    return iter.children[(int) (chars[i] - 'a')].search(nextStr);
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */