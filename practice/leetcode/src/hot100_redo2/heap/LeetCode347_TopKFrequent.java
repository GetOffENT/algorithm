package hot100_redo2.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>
 *     <a href="https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * </p>
 *
 * @author Yuxian Wu
 * @version 1.0
 * @since 2025-03-06 18:36
 */
public class LeetCode347_TopKFrequent {
    private static class Pair{
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {

            if (heap.size() < k) {
                heap.offer(new Pair(entry.getKey(), entry.getValue()));
                continue;
            }

            Pair peek = heap.peek();

            if (entry.getValue() > peek.count){
                heap.poll();
                heap.offer(new Pair(entry.getKey(), entry.getValue()));
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().num;
        }
        return ans;
    }
}
