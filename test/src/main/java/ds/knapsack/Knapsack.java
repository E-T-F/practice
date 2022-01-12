package ds.knapsack;

/**
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 */
public class Knapsack {
    public static void main(String[] args) {
        int N = 3, W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(new Knapsack().knapsack(W, N, wt, val));
    }

    int knapsack(int W, int N, int[] wt, int[] val) {

        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - wt[i - 1] < 0) {
                    //当前装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

}
