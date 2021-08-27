package com;

public class TwoPoint {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(4.0));
    }

    /**
     * 167. Two Sum II - Input array is sorted (Easy)
     * @date 2021/8/27 3:39 下午
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers != null && numbers.length > 0) {
            int i = 0, j = numbers.length - 1;
            int sum = 0;
            while (i < j) {
                sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                } else if (sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return null;
    }
}
