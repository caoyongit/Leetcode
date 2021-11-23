/**
 * @Title: Test.java
 * @Package: com
 * Company: 湖南教育出版社-贝壳网
 * Copyright (c) 2021, www.bakclass.com. All Rights Reserved.
 */
package com;

/**
 * Test
 *
 * @author caoyong
 * @date 2021/11/23 2:39 下午
 */
public class Test {

    public static void main(String[] args) {

        int nums[] = new int[]{9,8,5,1,3,5,6,3};
        /*int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j-1] < temp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }*/


        Test t = new Test();
        t.selectSort(nums);

        for (int n : nums) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

    public void selectSort(int[] nums) {
        int length = nums.length;
        for (int n = 0; n < length; n++) {
            int min = n;
            for (int m = n + 1; m < length; m++) {
                if (nums[min] > nums[m]) {
                    min = m;
                }
            }
            swap(nums, min, n);
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

}
