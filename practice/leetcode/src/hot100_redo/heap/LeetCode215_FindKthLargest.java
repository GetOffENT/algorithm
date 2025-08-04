package hot100_redo.heap;

import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 18:31
 */
public class LeetCode215_FindKthLargest {
    public int findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            heap.offer(numbers[i]);
        }

        for (int i = k; i < numbers.length; i++) {
            int peek = heap.peek();
            if (numbers[i] > peek) {
                heap.poll();
                heap.offer(numbers[i]);
            }
        }

        return heap.peek();
    }
}
