class Solution {
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList();
        Map<Character, Character> map = build();
        for (int i = 0; i < words.length; i++) {
            if (num.equals(get(words[i], map))) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private String get(String word, Map<Character, Character> map) {
        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(map.get(chars[i]));
        }
        return sb.toString();
    }

    private Map<Character, Character> build() {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');
        return map;
    }
}