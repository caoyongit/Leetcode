/**
 * @Title: MergeSort.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

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
     * @param mid [left, mid] 有序，[mid + 1, right] 有序
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

    public static void main(String[] args) {
        int []nums = new int[]{4,6,7,2,8,9,32,56};
        int[]ary = sortArray(nums);
        for (int a : ary) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
