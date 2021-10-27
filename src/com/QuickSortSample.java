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

    /**
     * 26.给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     *
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     * 提示：
     *     0 <= nums.length <= 3 * 104
     *     -104 <= nums[i] <= 104
     *     nums 已按升序排列
     *
     * @param nums
     * @return
     * @author abc
     * @date 2021/10/27 4:50 下午
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        QuickSortSample sample = new QuickSortSample();
        int[]nums=new int[]{1,1,2};
        System.out.println(sample.removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
