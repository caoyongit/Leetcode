package com;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,2,1};
        Arrays.stream(insertSorted2(nums)).forEach(s -> System.out.print(s + " "));
        //System.out.println(twoSum(nums, 9));
        System.out.println(3 % 7);
    }

    /**
     * 912 给你一个整数数组 nums，请你将该数组升序排列。
     * 选择排序
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

    /**
     * 1. 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 插入排序，逐个交换到前面合适的位置
     */
    public static int[] insertSorted(int []nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] <= nums[j - 1]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    /**
     * 插入排序2，先暂存当前变量，然后将前面的若干个元素逐个向后赋值
     */
    public static int[] insertSorted2(int []nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j-1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     进阶：
     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

}
