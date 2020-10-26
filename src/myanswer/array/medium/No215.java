package myanswer.array.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @FileName: No215.java
 * @Description: 数组中第K大的元素
 * @Author: camille
 * @Date: 2020/10/20 22:06
 */
public class No215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                // 保持堆的大小为k，不断把最小值弹出
                queue.poll();
            }
        }
        int res = queue.peek();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        return res;

    }

    public static void main(String[] args) {
        No215 no215 = new No215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int ans = no215.findKthLargest(nums, 4);
    }

}
