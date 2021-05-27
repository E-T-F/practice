package ds.dp.dp_stock;

/**
 * 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //equation
        //ds.dp[i][k][0] = Math.max(ds.dp[i - 1][k][0], ds.dp[i - 1][k][1] + prices[i]);
        //ds.dp[i][k][1] = Math.max(ds.dp[i - 1][k][1], ds.dp[i - 1][k - 1][0] - prices[i]);
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }


    public int maxProfit2(int[] prices) {
        //base case
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        //equation
        //ds.dp[i][k][0] = Math.max(ds.dp[i - 1][k][0], ds.dp[i - 1][k][1] + prices[i]);
        //ds.dp[i][k][1] = Math.max(ds.dp[i - 1][k][1], ds.dp[i - 1][k - 1][0] - prices[i]);
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            //k = 1, ds.dp[i - 1][k - 1][0] = 0
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
