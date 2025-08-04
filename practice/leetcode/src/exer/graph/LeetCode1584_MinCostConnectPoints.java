package exer.graph;

import java.util.*;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-26 9:51
 */
public class LeetCode1584_MinCostConnectPoints {

    private static class Pair {
        int vertex;
        int dist;

        public Pair(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int[] distances = new int[points.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        boolean[] visited = new boolean[points.length];

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.dist));
        minHeap.offer(new Pair(0, 0));

        int ans = 0;
        int count = 0;

        while (!minHeap.isEmpty() && count < points.length) {
            Pair poll = minHeap.poll();
            if (!visited[poll.vertex]) {
                visited[poll.vertex] = true;
                int[] point = points[poll.vertex];

                for (int i = 0; i < points.length; i++) {
                    if (!visited[i]) {
                        int[] child = points[i];
                        distances[i] = Math.min(distances[i], Math.abs(point[0] - child[0]) + Math.abs(point[1] - child[1]));
                        minHeap.offer(new Pair(i, distances[i]));
                    }
                }

                ans += distances[poll.vertex];
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ByKruskalAndDisjoint().minCostConnectPoints(
                new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}
        ));
        System.out.println(new ByKruskalAndDisjoint().minCostConnectPoints(
                new int[][]{{3, 12}, {-2, 5}, {-4, 1}}
        ));
        System.out.println(new ByKruskalAndDisjoint().minCostConnectPoints(
                new int[][]{{2, -3}, {-17, -8}, {13, 8}, {-17, -15}}
        ));
    }
}

class ByKruskal {

    private static class Edge {
        int vertex1, vertex2, weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(points.length * (points.length - 1) / 2, Comparator.comparingInt(edge -> edge.weight));

        List<Set<Integer>> sets = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(point[0] - points[j][0]) + Math.abs(point[1] - points[j][1]);
                minHeap.offer(new Edge(i, j, distance));
            }
        }

        int ans = 0;
        int count = 0;
        while (count < points.length - 1) {
            Edge poll = minHeap.poll();
            int i = find(sets, poll.vertex1);
            int j = find(sets, poll.vertex2);
            if (i == -1 && j == -1) {
                HashSet<Integer> set = new HashSet<>();
                set.add(poll.vertex1);
                set.add(poll.vertex2);
                sets.add(set);
                ans += poll.weight;
                count++;
            } else if (i != j) {
                if (i == -1) {
                    sets.get(j).add(poll.vertex1);
                } else if (j == -1) {
                    sets.get(i).add(poll.vertex2);
                } else {
                    merge(sets, i, j);
                }
                ans += poll.weight;
                count++;
            }
        }
        return ans;
    }

    private int find(List<Set<Integer>> sets, int num) {
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).contains(num)) {
                return i;
            }
        }
        return -1;
    }

    private void merge(List<Set<Integer>> sets, int i, int j) {
        Set<Integer> set1 = sets.get(i);
        Set<Integer> set2 = sets.remove(j);
        set1.addAll(set2);
    }
}


class ByKruskalAndDisjoint {

    private static class Edge {
        int vertex1, vertex2, weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(points.length * (points.length - 1) / 2, Comparator.comparingInt(edge -> edge.weight));

        int[] disjoint = new int[points.length];
        for (int i = 0; i < disjoint.length; i++) {
            disjoint[i] = i;
        }

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(point[0] - points[j][0]) + Math.abs(point[1] - points[j][1]);
                minHeap.offer(new Edge(i, j, distance));
            }
        }

        int ans = 0;
        int count = 0;
        while (count < points.length - 1) {
            Edge poll = minHeap.poll();
            int x = find(disjoint, poll.vertex1), y = find(disjoint, poll.vertex2);
            if (x != y) {
                union(disjoint, x, y);
                ans += poll.weight;
                count++;
            }
        }
        return ans;
    }

    private int find(int[] disjoint, int num) {
        if (disjoint[num] == num) {
            return num;
        }
        disjoint[num] = find(disjoint, disjoint[num]);
        return disjoint[num];
    }

    private void union(int[] disjoint, int x, int y) {
        disjoint[x] = y;
    }

}
