class Solution {
    // 双指针： 使用int[]来hash，使用Arrays.equals对比hash值
    public List<Integer> findAnagrams(String s, String p) {        
        List<Integer> result = new ArrayList<Integer>();
        int[] pHash = getHash(p);
        int[] sHash = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < chars.length) {
            sHash[chars[right] - 'a']++;
            if (right - left + 1 == p.length()) {
                if (Arrays.equals(sHash, pHash)) {
                    result.add(left);
                }
                sHash[chars[left] - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }

    private int[] getHash(String p) {
        int[] hash = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }
        return hash;
    }
}