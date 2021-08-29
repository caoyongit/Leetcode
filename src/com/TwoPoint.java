package com;

import java.util.Arrays;
import java.util.HashSet;

public class TwoPoint {

    public static void main(String[] args) {
        int [] num1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int [] num2 = new int[]{2,5,6};
        int n = 3;
        merge(num1, m , num2, n);
        Arrays.stream(num1).forEach(System.out::println);
//        int i = 0;
//        System.out.println(++i);
    }

    /**
     * 167. Two Sum II - Input array is sorted (Easy)
     *
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


    /**
     * 633. Sum of Square Numbers (Easy)
     */
    public static boolean judgeSquareSum(int c) {
        long i = 0, j = (long) Math.sqrt(c);
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 345. Reverse Vowels of a String (Easy)
     */
    public static String reverseVowels(String s) {
        if (s == null) return null;
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char lc = s.charAt(i);
            char rc = s.charAt(j);
            if (!vowels.contains(lc)) {
                result[i++] = lc;
            } else if (!vowels.contains(rc)) {
                result[j--] = rc;
            } else {
                result[i++] = rc;
                result[j--] = lc;
            }
        }
        return new String(result);
    }

    /**
     * 680. Valid Palindrome II (Easy)
     */
    public static boolean validPalindrome(String s) {
        if (s == null) return false;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 88. Merge Sorted Array (Easy)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1, idx2 = n - 1;
        int idxMerge = m + n - 1;
        while (idx2 >= 0 || idx1 >= 0) {
            if(idx1 < 0) {
                nums1[idxMerge--] = nums2[idx2--];
            } else if (idx2 < 0) {
                nums1[idxMerge--] = nums1[idx1--];
            } else if (nums1[idx1] > nums2[idx2]) {
                nums1[idxMerge--] = nums1[idx1--];
            } else {
                nums1[idxMerge--] = nums2[idx2--];
            }
        }
    }
}
