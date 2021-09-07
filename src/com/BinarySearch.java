/**
 * @Title: BinarySearch.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

import java.util.List;

/**
 * 二分查找
 *
 * @author caoyong
 * @date 2021/9/1 6:14 下午
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,0,1};
        System.out.println(findMin(nums));
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


    /**
     * 153. 寻找旋转排序数组中的最小值
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

     给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     */
    public static int findMin(int[] nums) {
        int left = 0, len = nums.length;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /**
     * 154  已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

     给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     */
    public static int findMin2(int[] nums) {
        int left = 0, len = nums.length;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 
     */
    public static int searchSpin(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
