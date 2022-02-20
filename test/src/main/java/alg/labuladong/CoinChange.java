package alg.labuladong;


import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(new CoinChange().coinChange(coins, 11));
    }

    int[] mem;
    public int coinChange(int[] coins, int amount) {

        mem = new int[amount + 1];
        Arrays.fill(mem, -2);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != -2) {
            return mem[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }

        mem[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return mem[amount];
    }


    public int coinChange1(int[] coins, int amount) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange1(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
