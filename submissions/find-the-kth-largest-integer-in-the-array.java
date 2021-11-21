class Solution {
    // 字符串排序
    public String kthLargestNumber(String[] numStrs, int k) {

        List<String> list = Arrays.stream(numStrs).sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) { return s1.length() - s2.length(); }
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return s1.charAt(i) - s2.charAt(i);
                    }
                }
                return 0;
            }
        }).collect(Collectors.toList());
        return list.get(numStrs.length - k);
    }
}