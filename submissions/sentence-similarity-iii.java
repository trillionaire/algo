class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] left = sentence1.split(" ");
        String[] right = sentence2.split(" ");
        if (left.length < right.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int i = 0;
        int j = 0;
        while (i < right.length && left[i].equals(right[i])) {
            i++;
        }
        if (i == right.length) {
            return true;
        }
        while (j < right.length && left[left.length - j - 1].equals(right[right.length - j - 1])) {
            j++;
        }
        if (j == right.length) {
            return true;
        }
        return (i + j == right.length);
    }
}