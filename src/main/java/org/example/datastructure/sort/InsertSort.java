package org.example.datastructure.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {8, 24, 31, 5, 7, 10, 47, 16, 72, 50, 21, 89};

        InsertSort is = new InsertSort();

        is.insertionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public void insertionSort(int[] array) {

        // 从第1个开始插入到前面
        for (int i = 1; i < array.length; i++) {

            // 当前的数
            int tmp = array[i];

            int j = i - 1;

            // 一直往前找到要插入的位置
            while (j >= 0 && tmp < array[j]) {
                // 往后腾出位置
                array[j+1] = array[j];
                j--;
            }

            // 此时j为要插入的位置
            array[j+1] = tmp;
        }
    }
}
