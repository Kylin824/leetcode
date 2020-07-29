package org.example.company.shopee;

import org.example.offer.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

public class PTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] preArr = new int[strs.length];
            int[] midArr = new int[preArr.length];
            for (int i = 0; i < strs.length; i++) {
                preArr[i] = Integer.valueOf(strs[i]);
                midArr[i] = preArr[i];
            }
            Arrays.sort(midArr);

            findLeaf(preArr, midArr);

        }
    }

    public static void findLeaf(int[] pre, int[] in) {
        // only root
        if (pre.length == 1 && in.length == 1) {
            System.out.print(pre[0] + " ");
            return;
        }
        int split = 0;
        while (in[split] != pre[0])
            split++;

        if (split == 0) {
            // no left tree
            int[] rightPre = Arrays.copyOfRange(pre, split + 1, pre.length);
            int[] rightIn = Arrays.copyOfRange(in, split + 1, in.length);
            findLeaf(rightPre, rightIn);
        }
        else if (split == in.length - 1) {
            // no right
            int[] leftPre = Arrays.copyOfRange(pre, 1, split + 1);
            int[] leftIn = Arrays.copyOfRange(in, 0, split);
            findLeaf(leftPre, leftIn);
        }
        else {
            int[] leftPre = Arrays.copyOfRange(pre, 1, split + 1);
            int[] leftIn = Arrays.copyOfRange(in, 0, split);
            int[] rightPre = Arrays.copyOfRange(pre, split + 1, pre.length);
            int[] rightIn = Arrays.copyOfRange(in, split + 1, in.length);
            findLeaf(leftPre, leftIn);
            findLeaf(rightPre, rightIn);
        }
    }

}
