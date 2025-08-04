package exer.graph;

import java.util.Arrays;

/**
 * <p>
 * Floyd-Warshall
 * <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-26 8:03
 */
public class LeetCode1334_FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j][i] != Integer.MAX_VALUE) {
                    for (int k = 0; k < n; k++) {
                        if (dist[i][k] != Integer.MAX_VALUE) {
                            dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                        }
                    }
                }
            }
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count ++;
                }
            }

            if (count <= min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1334_FindTheCity().findTheCity(
                4, new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4
        ));

        System.out.println(new LeetCode1334_FindTheCity().findTheCity(
                5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2
        ));
    }
}
