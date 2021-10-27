/**
 * @Title: MergeSort.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

import java.util.Arrays;
import java.util.List;

/**
 * 归并排序
 *
 * @author caoyong
 * @date 2021/10/9 9:15 上午
 */
public class MergeSort {

    /**
     * 对数组 nums 的子区间 [left..right] 进行归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @author caoyong
     * @date 2021/10/9 10:31 上午
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeOfTwoArray(nums, left, mid, right);
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @author caoyong
     * @date 2021/10/9 10:32 上午
     */
    private static void mergeOfTwoArray(int[] nums, int left, int mid, int right) {
        // 每做一次合并，都new数组用于归并，开销大
        int len = right - left + 1;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = nums[left + i];
        }

        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            // 先写 i 和 j 越界的情况
            if (i == mid + 1 - left) {
                nums[left + k] = temp[j];
                j++;
            } else if (j == right + 1 - left) {
                nums[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里必须写成 <=，否则归并排序就成了非稳定的排序
                nums[left + k] = temp[i];
                i++;
            } else {
                nums[left + k] = temp[j];
                j++;
            }
        }
    }

    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1);
        return nums;
    }


    /**
     * 剑指 Offer 51. 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * 示例 1:
     * 输入: [7,5,6,4]
     * 输出: 5
     * 限制：0 <= 数组长度 <= 50000
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right)
            return 0;

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return  leftPairs + rightPairs + crossPairs;
    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    /**
     * 315. 计算右侧小于当前元素的个数
     * 给你`一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     * 示例 1：
     * 输入：nums = [5,2,6,1]
     * 输出：[2,1,1,0]
     * 解释：
     * 5 的右侧有 2 个更小的元素 (2 和 1)
     * 2 的右侧仅有 1 个更小的元素 (1)
     * 6 的右侧有 1 个更小的元素 (1)
     * 1 的右侧有 0 个更小的元素
     *
     * 示例 2：
     * 输入：nums = [-1]
     * 输出：[0]
     *
     * 示例 3：
     * 输入：nums = [-1,-1]
     * 输出：[0,0]
     * @param nums
     * @return
     * @author abc
     * @date 2021/10/26 9:45 上午
     */
    public List<Integer> countSmaller(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,5,9,4,8,19,47,12,0,56,2};
        Arrays.stream(sortArray(nums)).forEach(i->System.out.print(i+" "));
    }
}
