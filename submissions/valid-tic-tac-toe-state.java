class Solution {
    // 数学：
    public boolean validTicTacToe(String[] board) {
        List<int[]> olist = new ArrayList();
        List<int[]> xlist = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            char[] arr = board[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if ('X' == arr[j]) { xlist.add(new int[]{i, j}); }
                if ('O' == arr[j]) { olist.add(new int[]{i, j}); }
            }
        }
        // X必须等于或比O多一个
        if (xlist.size() < olist.size() || xlist.size() > olist.size() + 1) {
            return false;
        }
        boolean oresult = check(olist);
        boolean xresult = check(xlist);
        // X和O不能均成线
        if (oresult == false && xresult == false) {return false;}
        // X成线时，不比O多一个
        if (xresult == false && (xlist.size() == olist.size())) { return false; }
        // O成线时，必须与X相等
        if (oresult == false && (xlist.size() > olist.size())) {return false;}
        return true;
    }

    private boolean check(List<int[]> list) {
        int[] lines = new int[3];
        int[] cols = new int[3];
        int cross1 = 0;
        int cross2 = 0;
        for (int i = 0; i < list.size(); i++) {
            // 记录每行数量，到3即返回
            if (++lines[list.get(i)[0]] == 3) {return false;}
            // 记录列数量，到3即返回
            if (++cols[list.get(i)[1]] == 3) {return false;}
            // 记录对角线数量，到3即返回
            if (list.get(i)[0] == list.get(i)[1]) {
                if (++cross1 == 3) {return false;}
            }
            // 记录反对角线数量，到3即返回
            if (list.get(i)[0] + list.get(i)[1] == 2) {
                if (++cross2 == 3) {return false;}
            }
        }
        return true;
    }
}