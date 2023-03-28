package org.example.hot100;

public class _4 {

    public static void main(String[] args) {


//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 双指针
     *
     * 时间：O(m+n)
     * 空间：O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        int target = (l1 + l2) / 2;

        if ((l1 + l2) % 2 == 0) {
            target--;
        }

        double res = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (count <= target) {

            if (i < l1 && j < l2) {
                if (nums1[i] <= nums2[j]) {
                    res = nums1[i];
                    i++;
                } else {
                    res = nums2[j];
                    j++;
                }
            } else if (i == l1) {
                res = nums2[j];
                j++;
            } else if (j == l2) {
                res = nums1[i];
                i++;
            }
            count++;
        }

        if ((l1 + l2) % 2 != 0) {
            return res;
        }

        if (i < l1 && j < l2) {
            if (nums1[i] <= nums2[j]) {
                res = (res + nums1[i]) / 2;
            } else {
                res = (res + nums2[j]) / 2;
            }
        } else if (i == l1) {
            res = (res + nums2[j]) / 2;
        } else if (j == l2) {
            res = (res + nums1[i]) / 2;
        }

        return res;

    }
}


