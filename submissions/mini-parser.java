/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    // DFS : 字符串 + 双指针。 注意子字符串条件(','或结束)和边界条件（[]）
    public NestedInteger deserialize(String s) {
        NestedInteger result = new NestedInteger();
        // case: empty
        if (s.isEmpty()) { return result; }
        // case: num
        if (s.charAt(0) != '[') { 
            result.setInteger(Integer.valueOf(s));
            return result;
        }
        // case：[] NOTE!
        if (s.length() == 2) return result;

        s = s.substring(1, s.length());
        int left = 0;
        int right = 0;
        int delta = 0;
        while (right < s.length()) {
            // substring is ok: ',' or end
            if (delta == 0 && (s.charAt(right) == ',' || right == s.length() - 1)) {
                result.add(deserialize(s.substring(left, right)));
                left = right + 1;
            } else if (s.charAt(right) == '[') {
                delta++;
            } if (s.charAt(right) == ']') {
                delta--;
            }
            right++;
        }
        return result;
    }
}