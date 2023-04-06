package org.example.offer.bst.structure.dp;

public class ZeroOnePacket {

    /*
    0-1背包问题
     */

    public static void main(String[] args) {
        int N = 5; // N类物品
        int Capacity = 10; // 背包总容量

        int[] weights = {0, 1, 10, 2, 3, 4}; // 每类物品重量
        int[] values = {0, 4, 8, 3, 2, 1}; // 每类物品价值

        System.out.println();
        System.out.println(zeroOnePack(N, Capacity, weights, values));

        zeroOnePackOpt(N, Capacity, weights, values);

    }

    public static String zeroOnePack(int N, int Capacity, int[] weights, int[] values) {

        //初始化动态规划数组
        int[][] dp = new int[N + 1][Capacity + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < Capacity + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则无法装入背包
                if (weights[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], // 不放入背包
                                        dp[i - 1][j - weights[i]] + values[i]); // 放入背包
            }
        }

        System.out.println("二维数组解法：");
        // 输出DP数组
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= Capacity; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("二维数组结果: " + dp[N][Capacity]);

        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][Capacity];
        //逆推找出装入背包的所有商品的编号
        int j = Capacity;
        String numStr = "MaxValue: " + maxValue + " , N: ";
        for (int i = N; i > 0; i--) {
            //如果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStr = numStr + " " + i;
                j = j - weights[i];
            }
            if (j == 0)
                break;
        }
        return numStr;
    }

    public static void zeroOnePackOpt(int N, int Capacity, int[] weights, int[] values) {

        // 优化版：使用一维数组
        int[] dp_one = new int[Capacity + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = Capacity; j >= 0; j--) { // 逆序进行
                if (j >= weights[i])
                    dp_one[j] = Math.max(dp_one[j], dp_one[j - weights[i]] + values[i]);
            }
            System.out.print("第" + i + "轮dp: ");
            for (int j = 0; j <= Capacity; j++) {
                System.out.print(dp_one[j] + " ");
            }
            System.out.println();
        }
        System.out.println("一维数组结果: " + dp_one[Capacity]);
    }
}
