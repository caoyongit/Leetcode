/**
 * @Title: QuickSort.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author caoyong
 * @date 2021/10/27 8:49 上午
 */
public class QuickSort2 {

    /**
     * 静态常量命名的时候全部使用大写字母
     */
    private static final Random RANDOM = new Random();

    public void sort(int []nums) {
        int lenght = nums.length;
        quickSort(nums, 0, lenght - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partions(nums , left , right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    public int partions(int[] nums, int left, int right) {
        // 随机选择一个元素作为切分元素
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int povit = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[ge] < povit) {
                le ++;
            }
            while (le <= ge && nums[ge] > povit) {
                ge --;
            }
            if (le > ge) {
                break;
            }
            swap(nums, le, ge);
            le ++;
            ge --;
        }
        swap(nums, left, ge);
        return ge;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort = new QuickSort2();
        int []nums = new int[]{5,8,2,8,4,1,16};
        quickSort.sort(nums);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
