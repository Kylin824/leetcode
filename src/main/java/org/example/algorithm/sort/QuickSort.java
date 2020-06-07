package org.example.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8, 24, 31, 5, 7, 10, 47, 16, 72, 50, 21, 89};

        QuickSort qs = new QuickSort();

        qs.quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = low;
        int index = pivot + 1;
        for (int i = index; i <= high; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
