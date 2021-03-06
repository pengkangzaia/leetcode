package datastructure.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1, 4, 3, 8,397,3295,29,4938,2192};
        /*quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));*/
        QuickSort quickSort = new QuickSort();
        //quickSort.quickSort(array);
        quickSort.quickSort0112(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            //为什么要先j后i呢
            // i在大于基准数的地方停下，j在小于基准数的地方停下，
            // 如果i先走，最后停下跟基准数交换时，总是大于基准数的。
            while (array[j] >= key && i < j) {
                j--;
            }
            while (array[i] <= key && i < j) {
                i++;
            }
//            while (array[j] >= key && i < j) {
//                j--;
//            }
            // 交换两个值
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }


    public void quickSort(int[] nums) {
        int n = nums.length;
        sort(nums, 0, n - 1);
    }

    public void sort(int[] nums, int low, int high) {
        if (low >= high) { return;}
        int key = nums[low];
        int left = low, right = high;
        while (left < right) {
            while (left < right && nums[right] >= key) {right--;}
            while (left < right && nums[left] <= key) {left++;}
            if (left < right) { swap(nums, left, right); }
        }
        swap(nums, low, left);
        sort(nums, low, left - 1);
        sort(nums, left + 1, high);
    }

    public void swap(int[] nums, int i, int j) {
        // i和j不能相等
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }


    public void quickSort0112(int[] nums) {
        sort0112_2(nums, 0, nums.length - 1);
    }

    private void sort0112(int[] nums, int low, int high) {
        if (low >= high) { return;}
        int key = nums[low];
        int left = low, right = high;
        while (left < right) {
            while (left < right && nums[right] >= key) { right--; }
            while (left < right && nums[left] <= key) { left++; }
            if (left < right) { swap(nums, left, right); }
        }
        swap(nums, low, left);
        sort0112(nums, low, left - 1);
        sort0112(nums, left + 1, high);
    }

    private void sort0112_2(int[] nums, int low, int high) {
        if (low >= high) { return; }
        int key = nums[low];
        int left = low, right = high;
        while (left < right) {
            while (left < right && nums[right] >= key) { right--; }
            while (left < right && nums[left] <= key) { left++; }
            if (left < right) { swap(nums, left, right); }
        }
        swap(nums, low, left); // 这一部分是导致快排不稳定的原因
        sort0112_2(nums, low, left - 1);
        sort0112_2(nums, left + 1, high);
    }




    private void sort_20210121(int[] nums, int low, int high) {
        if (low >= high) { return;}
        int left = low, right = high;
        int key = nums[low];
        while (left < right) {
            while (left < right && nums[right] >= key) { right--; }
            while (left < right && nums[left] <= key) { left++; }
            if (left < right) { swap(nums, left, right);}
        }
        swap(nums, low, left);
        sort_20210121(nums, low, left - 1);
        sort_20210121(nums, left + 1, high);
    }


































}
