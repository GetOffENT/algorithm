package hot100_redo.matrix;

/**
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 15:11
 */
public class LeetCode73_setZeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length], col = new int[matrix[0].length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
