package util;

public class ArrayUtils {

    public static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

    public static void nextPermutation(int[] arr) {
        int index = arr.length - 1;
        while (index > 0 ) {
            if (arr[index] > arr[index - 1]) {
                break;
            }
            index--;
        }
        int longestNoInIncIndex = index;
        int pivotIndex = longestNoInIncIndex - 1;
        if (pivotIndex == -1) {
            ArrayUtils.reverse(arr, 0, arr.length - 1);
            return;
        }
        int successorIndex = 0;
        for (int i = arr.length - 1; i > pivotIndex; i--) {
            if (arr[i] > arr[pivotIndex]) {
                successorIndex = i;
                break;
            }
        }
        ArrayUtils.swap(arr, pivotIndex, successorIndex);
        ArrayUtils.reverse(arr, longestNoInIncIndex, arr.length -1);
    }
}
