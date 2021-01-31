package ds.array.basic.classify;

public class MaxProfit {

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] equation = new int[prices.length][2];

        equation[0][0] = 0;
        equation[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            equation[i][0] = Math.max(equation[i - 1][0], equation[i - 1][1] + prices[i]);
            equation[i][1] = Math.max(equation[i - 1][1], equation[i - 1][0] - prices[i]);

        }
        return equation[prices.length - 1][0];
    }


    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

}
