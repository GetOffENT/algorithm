package exer.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * Dijkstra
 * <a href="https://leetcode.cn/problems/network-delay-time/">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-26 6:05
 */
public class LeetCode743_NetworkDelayTime {
    private static class Node {
        int index;
        List<Edge> children = new ArrayList<>();
        boolean visited = false;

        int distance = Integer.MAX_VALUE;

        public Node(int index) {
            this.index = index;
        }
    }

    private static class Edge {
        int time;
        Node node;

        public Edge(int time, Node node) {
            this.time = time;
            this.node = node;
        }
    }

    private static class Pair {
        Node node;
        int distance;

        public Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] time : times) {
            nodes[time[0]].children.add(new Edge(time[2], nodes[time[1]]));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        nodes[k].distance = 0;
        minHeap.offer(new Pair(nodes[k], 0));


        while (!minHeap.isEmpty()) {
            Pair poll = minHeap.poll();
            Node node = poll.node;
            if (!node.visited) {
                node.visited = true;
                for (Edge edge : node.children) {
                    Node child = edge.node;
                    if (!child.visited){
                        child.distance = Math.min(child.distance, node.distance + edge.time);
                        minHeap.offer(new Pair(child, child.distance));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].visited) {
                return -1;
            }
            ans = Math.max(ans, nodes[i].distance);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode743_NetworkDelayTime().networkDelayTime(
                new int[][]{
                        {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
                },4,2
        ));
    }
}
