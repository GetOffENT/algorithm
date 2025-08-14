package hot100_redo4.graph;

/**
 * <p>
 * <a href="https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-15 7:22
 */
public class LeetCode207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
    }


    // dfs解法
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode207_CourseSchedule().canFinish2(
                3,
                new int[][]{
                        {1, 0},
                        {1, 2},
                        {0, 1}
                }
        ));
    }
}
