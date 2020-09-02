package org.example.interview.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hanota {
    /*
    面试题 08.06. 汉诺塔问题
    在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
    一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
    (1) 每次只能移动一个盘子;
    (2) 盘子只能从柱子顶端滑出移到下一根柱子;
    (3) 盘子只能叠在比它大的盘子上。
    请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。

     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1)); // 如果n为1 则从A移到C
        }
        else {
            move(n - 1, A, C, B); // 把A的前n-1个盘子移动到B
            C.add(A.remove(A.size() - 1)); // 把A的第n个盘子移动到C
            move(n - 1, B, A, C); // 把B的前n-1个盘子移动到C
        }
    }
}
