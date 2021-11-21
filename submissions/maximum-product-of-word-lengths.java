class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        Map<String, Integer> map = getMap(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((map.get(words[i]) & map.get(words[j])) != 0 ) {
                    continue;
                }
                result = Math.max(result, words[i].length() * words[j].length());
            }
        }
        return result;
    }

    private Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            result.put(word, hash(word));
        }
        return result;
    }

    private int hash(String word) {
        int result = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result |= (1 << (chars[i] - 'a'));
        }
        return result;
    }
}