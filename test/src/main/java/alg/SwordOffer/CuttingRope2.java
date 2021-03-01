package alg.SwordOffer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 2 <= n <= 1000
 */
public class CuttingRope2 {

    public static void main(String[] args) {
        System.out.println(new CuttingRope2().cuttingRope3(120));
    }

    /**
     * 区别：大数
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.ONE);
        dp[2] = BigInteger.valueOf(1);
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = dp[i].max(dp[i - j].multiply(BigInteger.valueOf(j)).max(BigInteger.valueOf((i - j) * j)));
            }
        }
        return dp[n].remainder(BigInteger.valueOf(1000000007)).intValue();
    }


    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int frequency = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return BigInteger.valueOf(3).pow(frequency).remainder(BigInteger.valueOf(1000000007)).intValue();
        } else if (remainder == 1) {
            return BigInteger.valueOf(3).pow(frequency - 1).multiply(BigInteger.valueOf(4)).remainder(BigInteger.valueOf(1000000007)).intValue();
        }
        return BigInteger.valueOf(3).pow(frequency).multiply(BigInteger.valueOf(2)).remainder(BigInteger.valueOf(1000000007)).intValue();
    }

    public int cuttingRope3(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) res * n % 1000000007;
    }
}
