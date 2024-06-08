package com.echo.leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * */
public class CN_11_MaxArea {

    /**
     * 解题思路: 夹b法
     * */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = height[l] < height[r] ?
                    Math.max(res, (r - l) * height[l ++]) :
                    Math.max(res, (r - l) * height[r --]);
        }
        return res;
    }
}
