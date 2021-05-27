package alg.SwordOffer;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 2 <= n <= 58
 *
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(120));
    }

    /**
     * ds.dp
     * 状态转移方程： ds.dp[i] = Max(ds.dp[i], Max((i - j) * j, ds.dp[i - j] * j))
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }
        /**
         * 递归
         * @param n
         * @return
         */
    public int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cuttingRope2(n - i)));
        }
        return res;
    }


    /**
     * 递归优化
     * @param n
     * @return
     */
    public int cuttingRope3(int n) {
        int[] saved = new int[n + 1];
        saved[2] = 1;
        return cal(saved, n);
    }

    private int cal(int[] saved, int n) {
        //存在直接返回
        if (saved[n] != 0) {
            return saved[n];
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cal(saved, n - i)));
        }
        saved[n] = res;
        return res;
    }


    // 数学推论： 分成的段相等值最大，为3最大
    public int cuttingRope1(int n) {

        //要求 m > 1
        if (n < 3) {
            return n;
        }
        int frequency = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, frequency);
        } else if (remainder == 1) {
            return (int) (Math.pow(3, frequency - 1) * 4);
        }
        return (int) Math.pow(3, frequency) * 2;
    }


}
