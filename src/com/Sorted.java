package com;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        Arrays.stream(sortArray(nums)).forEach(System.out::print);
    }

    /**
     * 912 给你一个整数数组 nums，请你将该数组升序排列。
     */
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len ; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
        return nums;
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

}
