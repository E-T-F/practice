package ds.tree;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int amount, int[] count) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        for (int coin : coins) {
            int subAmount = coinChange(coins, amount - coin, count);
            if (subAmount == -1) {
                continue;
            }
            res = Math.min(res, 1 + subAmount);
        }
        count[amount - 1] = res == Integer.MAX_VALUE ? -1 : res;

        return count[amount - 1];
    }


    public int coinChange3(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] counter = new int[amount + 1];
        Arrays.fill(counter, amount + 1);
        counter[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                counter[i] = Math.min(1 + counter[i - coin], counter[i]);
            }
        }
        return counter[amount] == (amount + 1) ? -1 : counter[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subAmount = coinChange2(coins, amount - coin);
            if (subAmount == -1) {
                continue;
            }
            res = Math.min(res, 1 + subAmount);
        }

        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        return res;
    }
}
