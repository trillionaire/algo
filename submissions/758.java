/*
* 758. 字符串中的加粗单词
给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签<b>和</b>中的字母都会加粗。

返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。

例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。注意返回 "aabcd" 会使用更多的标签，因此是错误的。



提示：

words 长度的范围为 [0, 50]。
words[i] 长度的范围为 [1, 10]。
S 长度的范围为 [0, 500]。
所有 words[i] 和 S 中的字符都为小写字母。


注：此题与「616 - 给字符串添加加粗标签」相同 - https://leetcode-cn.com/problems/add-bold-tag-in-string/*/
public class lt758 {
    public String boldWords(String[] words, String s) {
        boolean[] mark = new boolean[s.length()];
        for (String word : words) {
            int pre = 0;
            int index = 0;
            while ((index = s.indexOf(word, pre)) != -1) {
                Arrays.fill(mark, index, index + word.length(), true);
                pre = index + 1;
            }
        }
        // 1100  0011 1010
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < s.length()) {
            if (right != 0 && mark[right - 1] != mark[right]) {
                // 1
                if (mark[right - 1] == true) {
                    sb.append("<b>").append(s.substring(left, right)).append("</b>");
                    left = right;
                } else {
                    sb.append(s.substring(left, right));
                    left = right;
                }
            }
            right++;
        }
        if (left != right) {
            if (mark[right - 1] == true) {
                sb.append("<b>").append(s.substring(left, right)).append("</b>");
            } else {
                sb.append(s.substring(left, right));
            }
        }
        return sb.toString();
    }