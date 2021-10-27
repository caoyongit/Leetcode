/**
 * @Title: QuickSortSample.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

/**
 * 快速排序列子
 *
 * @author caoyong
 * @date 2021/10/27 10:34 上午
 */
public class QuickSortSample {

    /**
     *  剑指 Offer II 076. 数组中的第 k 大的数字
     *  给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。排序
     *
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 提示：
     *     1 <= k <= nums.length <= 104
     *     -104 <= nums[i] <= 104
     *
     * @author abc
     * @date 2021/10/27 10:39 上午
     */
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        return quickSelect(nums, 0 , length - 1, length - k);
    }

    private int quickSelect(int[]nums, int left, int right, int kThIdx) {
        int kth = partition(nums, left, right);
        if (kth == kThIdx) {
            return nums[kth];
        } else {
            return kth < kThIdx ? quickSelect(nums, kth + 1, right, kThIdx) : quickSelect(nums, left, kth - 1, kThIdx);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int poive = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < poive) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        QuickSortSample sample = new QuickSortSample();
        int[]nums=new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(sample.findKthLargest(nums, 4));
    }
}
