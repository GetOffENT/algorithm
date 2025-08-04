package hot100_redo2.backtracking;

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
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];


        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    visited[i][j] = true;
                    if (backtrace(board, i, j, chars, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean[][] visited;
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private boolean backtrace(char[][] board, int x, int y, char[] word, int index) {
        if (index == word.length) {
            return true;
        }

        for (int[] direction : directions) {
            int nextX = x + direction[0], nextY = y + direction[1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && !visited[nextX][nextY]) {
                if (board[nextX][nextY] == word[index]) {
                    visited[nextX][nextY] = true;
                    if (backtrace(board, nextX, nextY, word, index + 1)){
                        return true;
                    }
                    visited[nextX][nextY] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new LeetCode79_WordSearch().exist(
                        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                        "ABCCED"
                )
        );

        System.out.println(
                new LeetCode79_WordSearch().exist(
                        new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}},
                        "AAB"
                )
        );
    }
}
