package alg.SwordOffer;

/**
 *
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * @Auther: etf
 * @Date: 2021-02-23 23:49
 * @Description:
 */
public class Fib {

    public int fib(int n) {

        if (n < 1) {
            return 0;
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000007;;
        }
        return fib[n];
    }
}
