package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {16, 15, 10, 50, 17, 20, 18};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    public int partition(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        int pivotIndex = (r + l) / 2;
        int temp;
        while (l < r) {
            while (arr[l] <= arr[pivotIndex] && l < r) l++;
            while (arr[r] >= arr[pivotIndex] && l < r) r--;

            //swap
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }//when loop finished, l met r
        //swap the pivot to the met place
        int pivot = arr[pivotIndex];
        arr[pivotIndex] = arr[r];
        arr[l] = pivot;
        pivotIndex = l;
        return pivotIndex;
    }
}
