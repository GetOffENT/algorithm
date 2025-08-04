package hot100_redo.backtracking;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-12 17:44
 */
public class LeetCode79_WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        int row = board.length;
        int col = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrace(board, i, j, chars, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private boolean backtrace(char[][] board, int x, int y, char[] word, int index, boolean[][] visited) {
        if (board[x][y] != word[index]) {
            return false;
        }

        if (index == word.length - 1) {
            return true;
        }

        visited[x][y] = true;

        boolean flag = false;
        for (int[] direction : directions) {
            int nextX = x + direction[0], nextY = y + direction[1];
            if ((nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) &&
                    !visited[nextX][nextY]) {
                flag = backtrace(board, nextX, nextY, word, index + 1, visited);
                if (flag) {
                    break;
                }
            }
        }
        visited[x][y] = false;
        return flag;
    }


    public static void main(String[] args) {
        System.out.println(
                new LeetCode79_WordSearch().exist(
                        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                        "ABCCED"
                )
        );
    }
}
