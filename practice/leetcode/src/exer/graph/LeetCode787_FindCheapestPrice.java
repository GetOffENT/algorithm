package exer.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * Bellman-Ford
 * <a href="https://leetcode.cn/problems/cheapest-flights-within-k-stops/description/">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-26 6:53
 */
public class LeetCode787_FindCheapestPrice {

    public static void main(String[] args) {
        System.out.println(new LeetCode787_FindCheapestPrice().findCheapestPrice(
                4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1
        ));

        System.out.println(new LeetCode787_FindCheapestPrice().findCheapestPrice(
                4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1
        ));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        nodes[src].cost = 0;
        nodes[src].tempCost = 0;
        for (int i = 0; i < k + 1; i++) {
            for (int[] flight : flights) {
                Node from = nodes[flight[0]], to = nodes[flight[1]];
                int price = flight[2];

                if (from.tempCost != Integer.MAX_VALUE) {
                    to.cost = Math.min(to.cost, from.tempCost + price);
                }
            }

            for (Node node : nodes) {
                node.tempCost = node.cost;
            }
        }

        return nodes[dst].cost == Integer.MAX_VALUE ? -1 : nodes[dst].cost;

    }

    private static class Node {
        int index;

        int tempCost = Integer.MAX_VALUE;
        int cost = Integer.MAX_VALUE;

        public Node(int index) {
            this.index = index;
        }
    }
}
