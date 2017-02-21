package me.tony.practice.algorithm;

import me.tony.practice.Base;
import org.junit.Test;

/**
 * Created by tony on 2017/2/17.
 */
public class IntSort extends Base {

    static void quicksort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    static void quicksort(int[] nums, final int start, final int end) {
        int i = start;
        int j = end;
        int keyIndex = start;
        for (; i < j; ) {
            for (; j > keyIndex; j--) {
                if (nums[j] < nums[keyIndex]) {
                    int temp = nums[j];
                    nums[j] = nums[keyIndex];
                    nums[keyIndex] = temp;
                    keyIndex = j;
                    break;
                }
            }
            for (; i < keyIndex; i++) {
                if (nums[i] > nums[keyIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[keyIndex];
                    nums[keyIndex] = temp;
                    keyIndex = i;
                    break;
                }
            }
        }
        if (keyIndex > start + 1) {
            quicksort(nums, start, keyIndex - 1);
        }
        if (keyIndex < end - 1) {
            quicksort(nums, keyIndex + 1, end);
        }
    }

    static void bubblesort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    @Test
    public void testQuickSort() {
        int[] ints = new int[]{6, 2, 67, 23, 17, 5, 1, 2, 8, 4};
        long t1 = System.nanoTime();
        quicksort(ints);
        long t2 = System.nanoTime();
        ints = new int[]{6, 2, 67, 23, 17, 5, 1, 2, 8, 4};
        long t3 = System.nanoTime();
        bubblesort(ints);
        long t4 = System.nanoTime();
        System.out.println(t2 - t1);
        System.out.println(t4 - t3);

    }
}
