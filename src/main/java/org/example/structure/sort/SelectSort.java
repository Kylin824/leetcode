package org.example.structure.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {8, 24, 31, 5, 7, 10, 47, 16, 72, 50, 21};

        SelectSort ss = new SelectSort();

        ss.selectionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
