package alg.SwordOffer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2, -2147483648));
    }

    /**
     * n = x1 * 2^0 + x2 * 2^1 + x3 * 2^n-1
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long temp = n;

//        n∈[−2147483648,2147483647] ，会越界先转long
        if (temp < 0) {
            temp = -temp;
            x = 1 / x;
        }

        double res = 1;
        while (temp > 0) {
            if ((temp & 1) == 1) {
                res *= x;
            }
            x *= x;
            temp >>= 1;
        }
        return res;
    }


    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int abs = Math.abs(n);
        double val = x;
        while (abs > 1) {
            val *= x;
            abs--;
        }
        if (n < 0) {
            return 1d / val;
        } else {
            return val;
        }
    }
}
