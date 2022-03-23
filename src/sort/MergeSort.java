package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        ms.mergeSort(arr,temp,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(arr,temp,left,mid);//向左递归
            mergeSort(arr, temp, mid+1, right);//向右递归
            merge(arr, left, right, mid, temp);//合并
        }
    }

    /**
     * @param arr   原数组
     * @param left  递归左边
     * @param right 递归右边
     * @param mid   递归中间
     * @param temp  临时数组
     */
    public void merge(int[] arr, int left, int right, int mid, int[] temp) {
        System.out.print("left = " + left);
        System.out.println("right = " + right);
        //1.两个有序数组进行比较,并放入临时数组(合并)
        int t = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //2.把剩下的数一次性填入到临时数组
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3.把临时数组拷贝到arr[]的对应部分l->r
        t = 0;//重新归0
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
