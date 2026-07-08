package org.example.structure.sort;

/**
 * 冒泡排序：O(n^2)，稳定
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {8, 24, 31, 5, 7, 10, 47, 16, 72, 50, 21};

        BubbleSort bs = new BubbleSort();

        bs.bubbleSort(array);

        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}
