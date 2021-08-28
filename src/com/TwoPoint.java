package com;

import java.util.Arrays;
import java.util.HashSet;

public class TwoPoint {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
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
        return  true;
    }
}
