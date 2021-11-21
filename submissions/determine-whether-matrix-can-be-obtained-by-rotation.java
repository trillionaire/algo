class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {      
        for (int i = 0; i < 4; i++) {
            mat = rotate(mat);
            if (isSame(target, mat)) {
                return true;
            }            
        }
        return false;
    }

    private int[][] rotate(int[][] mat) {
        int[][] target = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                target[j][mat.length - 1 - i] = mat[i][j];
            }
        }
        return target;
    }

    private boolean isSame(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}