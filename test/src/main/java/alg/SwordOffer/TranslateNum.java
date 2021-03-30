package alg.SwordOffer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @Auther: etf
 * @Date: 2021-03-30 22:55
 * @Description:
 */
public class TranslateNum {

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(25));
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int temp = Integer.valueOf(s.substring(i - 2, i));
            if (temp >= 10 && temp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    /**
     * 节省空间，除余法
     *
     * @param num
     * @return
     */
    public int translateNum2(int num) {

        int a = 1, b = 1, x = num % 10, y;

        while (num != 0) {
            num /= 10;
            y = num % 10;
            int temp = y * 10 + x;
            int c = a;
            if (temp >= 10 && temp <= 25) {
                c = a + b;
            }
            b = a;
            a = c;
            x = y;
        }
        return a;

    }
}
