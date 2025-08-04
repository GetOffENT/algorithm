package hot100.array;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * @author Will
 * @version 1.0
 * @Description: TODO
 * @Create: 2024-09-11 14:30
 */
public class LeetCode53_maxSubArray {
    public int maxSubArray(int[] nums) {

        int dp = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Integer.max(dp + nums[i], nums[i]);
            ans = Integer.max(ans, dp);
        }

        return ans;
    }


    /**
     * 分治解题
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        Node root = split(nums, 0, nums.length - 1);
        return root.max;
    }


    private static Node split(int[] array, int low, int high) {
        if (low == high) {
            return new Node(low + 1, high + 1, array[low], array[low], array[low], array[low]);
        }

        int mid = (low + high) >>> 1;
        Node left = split(array, low, mid);
        Node right = split(array, mid + 1, high);

        // merge
        Node node = new Node(low + 1, high + 1, left.sum + right.sum,
                Math.max(Math.max(left.max, right.max), left.rmax + right.lmax),
                Math.max(left.lmax, left.sum + right.lmax),
                Math.max(right.rmax, right.sum + left.rmax));
        node.left = left;
        node.right = right;
        return node;
    }

    private static class Node {
        Node left, right;
        int l, r;
        int sum, max, lmax, rmax;

        public Node(int l, int r, int sum, int max, int lmax, int rmax) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.max = max;
            this.lmax = lmax;
            this.rmax = rmax;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode53_maxSubArray().maxSubArray(new int[]{-2, 1}));
    }
}
