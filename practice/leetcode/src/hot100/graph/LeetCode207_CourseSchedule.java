package hot100.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    private static class Node {
        int index;
        List<Node> children = new ArrayList<>();

        int inDegree = 0;

        public Node(int index) {
            this.index = index;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[1]].children.add(nodes[prerequisite[0]]);
            nodes[prerequisite[0]].inDegree++;
        }

        Queue<Node> queue = new LinkedList<>();
        for (Node node : nodes) {
            if (node.inDegree == 0) {
                queue.offer(node);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    if (--child.inDegree == 0) {
                        queue.offer(child);
                    }
                }
            }
        }

        for (Node node : nodes) {
            if (node.inDegree != 0) {
                return false;
            }
        }
        return true;
    }


    // dfs解法
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[1]].children.add(nodes[prerequisite[0]]);
            nodes[prerequisite[0]].inDegree++;
        }

        // 0 未访问，1正在访问，2结束访问
        Queue<Node> queue = new LinkedList<>();
        for (Node node : nodes) {
            if (node.inDegree == 0) {
                queue.offer(node);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }
        int[] visited = new int[nodes.length];
        while (!queue.isEmpty()) {
            if (!dfs(queue.poll(), visited)) {
                return false;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Node node, int[] visited) {
        visited[node.index] = 1;
        for (Node child : node.children) {
            if (visited[child.index] == 0) {
                if (!dfs(child, visited)) {
                    return false;
                }
            } else if (visited[child.index] == 1) {
                return false;
            }
        }
        visited[node.index] = 2;
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
