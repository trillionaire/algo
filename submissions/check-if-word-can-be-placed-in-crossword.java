class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        StringBuilder words = new StringBuilder(word);
        String wordReverse = words.reverse().toString();
        for (int i = 0; i < board.length; i++) {
            char[] list = board[i];
            if (canFill(list, word) || canFill(list, wordReverse)) {
                return true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            char[] list = new char[board.length];
            for (int j = 0; j < list.length; j++) {
                list[j] = board[j][i];
            }
            if (canFill(list, word) || canFill(list, wordReverse)) {
                return true;
            }
        }

        return false;
    }

    private boolean canFill(char[] list, String word) {
        int index = 0;
        for (int r = 0; r < list.length; r++) {
            if (list[r] == ' ' || list[r] == word.charAt(index)) {
                index++;
            } else if (list[r] == '#') {
                index = 0;
            } else {
                while (r < list.length && list[r] != '#') {
                    r++;
                }
                if (r == list.length || r + word.length() >= list.length) {
                    return false;
                }
                index = 0;
            }

            if (index == word.length()) {
                if (r == list.length - 1 || list[r + 1] == '#') {
                    return true;
                } else {
                    while (r < list.length && list[r] != '#') {
                        r++;
                    }
                    if (r == list.length || r + word.length() >= list.length) {
                        return false;
                    }
                    index = 0;
                }
            }
        }

        return false;
    }

}