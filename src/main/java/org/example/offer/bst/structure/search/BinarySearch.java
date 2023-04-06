package org.example.offer.bst.structure.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {8, 10, 13, 16, 19, 20, 23, 26, 29, 33, 41};

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(array, 26));

    }

    private int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            }
            else if (array[mid] > target) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
