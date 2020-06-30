package org.example.offer;

public class MinNumInRotatedArray {

    /*
        NO.06
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    /*
        思路:
            特殊情况：空，完全旋转
            1. 暴力，超时
            2. 二分查找
                正常情况: {3,4,5,1,2}
                特殊情况: {1,0,1,1,1}
        tips: mid = (left + right) / 2

     */
    public static int minNumberInRotateArray1(int [] array) {
        if (array.length <= 0)
            return 0;
        if (array[0] < array[array.length - 1])
            return array[0];
        int min = 0;
        int i = 0;
        while (i <= array.length - 1 && array[i] <= array[i+1]) {
            i++;
        }
        return Math.min(array[i + 1], array[0]);

    }

    public static int minNumberInRotateArray2(int [] array) {
        if (array.length <= 0)
            return 0;
        if (array[0] < array[array.length - 1])
            return array[0];

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            // int mid = (left + right) / 2;
            int mid = left + ((right - left) / 2);

            // 最小值在右半边
            if (array[mid] > array[right]) {
                left = mid + 1;
            }
            // 最小值在左半边
            else if (array[mid] < array[right]) {
                right = mid;
            }
            // 重复值太多，最小值不确定在哪边，只能缩小范围
            else {
                --right;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
//        int[] arr = {1, 2, 1, 1, 1};
//        System.out.println(minNumberInRotateArray1(arr));
        System.out.println(minNumberInRotateArray2(arr));

    }

}
