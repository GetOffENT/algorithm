package hot100_redo3.backtracking;

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
        return true;
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
