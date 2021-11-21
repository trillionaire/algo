class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        while (right < cardPoints.length) {
            total += cardPoints[right];
            sum += cardPoints[right];
            if (right - left + 1 == cardPoints.length - k) {
                min = Math.min(min, sum);
                sum -= cardPoints[left];
                left++;
            }
            right++;
        }
        return (cardPoints.length == k) ? total : (total - min);
    }
}