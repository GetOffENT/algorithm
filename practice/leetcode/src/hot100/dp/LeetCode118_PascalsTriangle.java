package hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/pascals-triangle/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 19:22
 */
public class LeetCode118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows >= 1) ans.add(List.of(1));
        if (numRows >= 2) ans.add(List.of(1, 1));

        for (int i = 3; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> lastRow = ans.get(ans.size() - 1);

            temp.add(1);
            for (int j = 1; j < lastRow.size(); j++) {
                temp.add(lastRow.get(j-1) + lastRow.get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}
