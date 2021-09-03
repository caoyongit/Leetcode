/**
 * @Title: BinarySearch.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

/**
 * 二分查找
 *
 * @author caoyong
 * @date 2021/9/1 6:14 下午
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = new int[]{3,5,6,8,9};
        System.out.println(searchFirstElement(nums, 8));
    }


    /**
     * 704 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target,
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public static int search(int[] nums, int target) {
        if (nums == null) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 704
     */
    public static int search1(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid, right]
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /*
     * 374 猜数字大小
     */
    /*public int guessNumber(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }*/

    /**
     * 35 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     */
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int first = searchFirstElement(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = searchLastElement(nums, target);
        return new int[]{first, last};
    }

    private static int searchFirstElement(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int searchLastElement(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
