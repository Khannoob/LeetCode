package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {16, 15, 10, 50, 17, 20, 18};
        HeapSort hs = new HeapSort();
        hs.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] arr) {
        //1.adjust a heap(max-heap)
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        //2.swap the root with lastIndex and cut, recover heap
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, j);
        }

    }


    private void heapify(int[] tree, int rootIndex, int n) {
        while (rootIndex * 2 + 2 <= n) {
            int clIndex = rootIndex * 2 + 1;
            int crIndex = rootIndex * 2 + 2;

            if (crIndex < n && tree[clIndex] < tree[crIndex]) {
                clIndex = crIndex;
            }
            if (tree[rootIndex] >= tree[clIndex]) {
                break;
            }
            //do swap
            int temp = tree[rootIndex];
            tree[rootIndex] = tree[clIndex];
            tree[clIndex] = temp;
            rootIndex = clIndex;
        }
    }
}
