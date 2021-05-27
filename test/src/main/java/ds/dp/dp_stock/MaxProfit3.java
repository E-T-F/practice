package ds.dp.dp_stock;

/**
 * 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
public class MaxProfit3 {

    public int maxProfit(int[] prices, int m) {
        if (prices.length <= 0) {
            return 0;
        }
        //如果  max_k > prices.length / 2，因为买入卖出至少需要2天，所以当超过一半，其实等价于不限制操作次数
        int max_k = m;

        int[][][] dp = new int[prices.length][max_k + 1][2];
        //base case
        for (int k = 0; k <= max_k; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        //equation
        //ds.dp[i][k][0] = Math.max(ds.dp[i - 1][k][0], ds.dp[i - 1][k][1] + prices[i]);
        //ds.dp[i][k][1] = Math.max(ds.dp[i - 1][k][1], ds.dp[i - 1][k - 1][0] - prices[i]);
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }

        }
        return dp[prices.length - 1][max_k][0];
    }


}
