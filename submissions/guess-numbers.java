class Solution {
    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            res += (guess[i] == answer[i]) ? 1 : 0;
        }
        return res;
    }
}