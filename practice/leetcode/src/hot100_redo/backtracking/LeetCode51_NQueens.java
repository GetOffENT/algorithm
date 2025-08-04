package hot100_redo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 3:05
 */
public class LeetCode51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        // 第n列有无皇后
        boolean[] hasQueue = new boolean[n];
        // 对角线
        boolean[] hasQueue1 = new boolean[2 * n - 1];
        // 反对角线
        boolean[] hasQueue2 = new boolean[2 * n - 1];

        backtrace(0, n, hasQueue, hasQueue1, hasQueue2, ans, temp);

        return ans;
    }

    private void backtrace(int index, int n, boolean[] hasQueue, boolean[] hasQueue1, boolean[] hasQueue2,
                           List<List<String>> ans, List<String> temp) {
        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            int diagonal = index - i + n - 1, backDiag = index + i;
            if (!hasQueue[i] && !hasQueue1[diagonal] && !hasQueue2[backDiag]) {
                hasQueue[i] = true;
                hasQueue1[diagonal] = true;
                hasQueue2[backDiag] = true;
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[i] = 'Q';
                temp.add(String.valueOf(line));

                backtrace(index + 1, n, hasQueue,hasQueue1, hasQueue2, ans, temp);

                temp.remove(temp.size() - 1);
                hasQueue[i] = false;
                hasQueue1[diagonal] = false;
                hasQueue2[backDiag] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode51_NQueens().solveNQueens(4));
    }
}
