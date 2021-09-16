package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoPoint {

    public static void main(String[] args) {
        /*int [] num1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int [] num2 = new int[]{2,5,6};
        int n = 3;
        merge(num1, m , num2, n);
        Arrays.stream(num1).forEach(System.out::println);*/
//        int i = 0;
//        System.out.println(++i);
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
//        dictionary.add("plea");
        System.out.println(findLongestWord("abpcplea", dictionary));

        int [] num2 = new int[]{0,1,0,3,12};
        moveZeroes(num2);
        Arrays.stream(num2).forEach(System.out::println);
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

    /**
     * 524. Longest Word in Dictionary through Deleting (Medium)
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String target : dictionary) {
            int L1 = longestWord.length(), L2 = target.length();
            // 获取长度最长且字典顺序最小的字符串
            if (L1 > L2 || (L1 == L2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (subStr(target, s)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private static boolean subStr(String target, String s) {
        int i = 0, j = 0;
        while (i < target.length() && j < s.length()) {
            if (target.charAt(i) == s.charAt(j)) {
                i ++;
            }
            j ++;
        }
        return  i == target.length();
    }

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     */
    public static int maxArea(int[] height) {
        int left = 0,right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return res;
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) return;
        int n = nums.length,left = 0,right = 0;
        while(right < n) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left ++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
