class Solution {
    public String tictactoe(String[] board) {
        String result = "Draw";
        boolean hasEmpty = false;
        int rSum = 0;
        int cSum = 0;
        int xSum = 0;
        int rxSum = 0;
        for (int i = 0; i < board.length; i++) {
            rSum = 0;
            cSum = 0;
            hasEmpty = board[i].contains(" ");
            for (int j = 0; j < board[i].length(); j++) {
                rSum += board[i].charAt(j);
                cSum += board[j].charAt(i);
            }
            result = getString(board, rSum, cSum);
            if (result != null) return result;
            xSum += board[i].charAt(i);
            rxSum += board[i].charAt(board.length - i - 1);
        }
        String x = getString(board, xSum, rxSum);
        if (x != null) return x;
        return (hasEmpty) ? "Pending" : "Draw";
    }

    private String getString(String[] board, int rSum, int cSum) {
        if (rSum == 'O' * board.length || cSum == 'O' * board.length) {
            return "O";
        }
        if (rSum == 'X' * board.length || cSum == 'X' * board.length) {
            return "X";
        }
        return null;
    }
}