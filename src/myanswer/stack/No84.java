package myanswer.stack;

import java.lang.reflect.Proxy;

/**
 * @FileName: No84.java
 * @Description: No84.java类说明
 * @Author: admin
 * @Date: 2020/11/2 19:26
 */
public class No84 {

    // 暴力解法
    public static int largestRectangleArea(int[] heights) {
        int res = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            // 注意索引位置
            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= heights[i]) {
                right++;
            }
            res = Math.max((right - left + 1) * heights[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] h = {2, 1, 5, 6, 2, 3};
        int[] s = {1, 1};
        int ans = largestRectangleArea(h);
        System.out.println(ans);
    }


}