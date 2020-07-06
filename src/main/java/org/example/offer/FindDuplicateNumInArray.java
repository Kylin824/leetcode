package org.example.offer;

public class FindDuplicateNumInArray {
    /*
        NO.50
        一个长度为n的数组里的所有数字都在0到n-1的范围内，数组中某些数字是重复的，但不知道有几个数字是重复的。
        找出数组中任意一个重复的数字。
     */
    /*
        思路:
            1. 哈希(这里数字有范围(0-n-1，可以直接用数组代替hash)+遍历

            2. 排序+遍历

            3. in-place方法，利用数字0-n-1范围的特性，将数字i交换到对应的number[i]上,如果此时number[i]已经是i，则发现重复
     */
    public boolean duplicate(int numbers[], int length, int [] duplication) {
        int[] dup = new int[length];
        for (int i = 0; i < length; i++) {
            if (dup[numbers[i]] == 0)
                dup[numbers[i]]++;
            else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static boolean duplicate1(int numbers[], int length, int [] duplication) {
        for (int i = 0; i < length; i++) {
            int tmp = numbers[i];
            if (numbers[i] != i && numbers[tmp] != tmp ) {
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
            else if (numbers[i] != i && numbers[tmp] == tmp ){
                duplication[0] = tmp;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,1,4};
        int[] dup = new int[1];
        boolean f = duplicate1(arr, arr.length, dup);


    }

}
