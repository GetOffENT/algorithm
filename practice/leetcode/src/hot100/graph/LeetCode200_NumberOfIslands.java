package hot100.graph;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-14 12:42
 */
public class LeetCode200_NumberOfIslands {

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int[] direction : directions) {
            int nextX = x + direction[0], nextY = y + direction[1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                    && !visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                dfs(grid, visited, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode200_NumberOfIslands().numIslands(
                new char[][]{
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }
        ));
    }
}
