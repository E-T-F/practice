package alg.SwordOffer;

/**
 *
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * @Auther: etf
 * @Date: 2021-02-24 00:04
 * @Description:
 */
public class NumWays {

    public int numWays(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public int numWays2(int n) {
        if (n < 1) {
            return 1;
        }
        int[] fib = new int[n + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 0; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000007;
        }
        return fib[n];
    }
}
