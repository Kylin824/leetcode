package org.example.interview.array;

public class GuessGame {
    /*
    面试题 16.15. 珠玑妙算
    给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。

    示例：
    输入： solution="RGBY",guess="GGRR"
    输出： [1,1]
    解释： 猜中1次(G)，伪猜中1次(R)。
    */
    public static int[] masterMind(String solution, String guess) {
        int right = 0, fakeRight = 0;
        char[] sc = solution.toCharArray();
        char[] gc = guess.toCharArray();
        int[] dict = new int[128];
        for (int i = 0; i < gc.length; i++) {
            if (sc[i] == gc[i]) { // 该位置猜中
                gc[i] = '/';
                right++;
            } else {
                dict[sc[i]]++; // 未猜中，存入map中
            }
        }
        for (int i = 0; i < gc.length; i++) {
            if (dict[gc[i]] > 0) {
                dict[gc[i]]--;
                fakeRight++;
            }
        }
        return new int[]{right, fakeRight};
    }

    public static int[] masterMindOpt(String solution, String guess) {
        int hit = 0, pseHit = 0;
        int[] map = new int[4];
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                hit++;
            } else {
                switch (solution.charAt(i)) {
                    case 'R': map[0]++; break;
                    case 'G': map[1]++; break;
                    case 'B': map[2]++; break;
                    case 'Y': map[3]++; break;
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == 'R' && map[0] > 0 && solution.charAt(i) != 'R') {
                pseHit++;
                map[0]--;
            }
            if (guess.charAt(i) == 'G' && map[1] > 0 && solution.charAt(i) != 'G') {
                pseHit++;
                map[1]--;
            }
            if (guess.charAt(i) == 'B' && map[2] > 0 && solution.charAt(i) != 'B') {
                pseHit++;
                map[2]--;
            }
            if (guess.charAt(i) == 'Y' && map[3] > 0 && solution.charAt(i) != 'Y') {
                pseHit++;
                map[3]--;
            }
        }
        return new int[]{hit, pseHit};
    }

    public static void main(String[] args) {
        int[] ret = masterMind("RGRB", "BBBY");
        System.out.println(ret[0] + " " + ret[1]);
    }
}
