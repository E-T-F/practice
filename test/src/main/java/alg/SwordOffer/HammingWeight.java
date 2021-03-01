package alg.SwordOffer;

/**
 *
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * @Auther: etf
 * @Date: 2021-02-24 00:32
 * @Description:
 */
public class HammingWeight {

    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {

        // 11000
        // 10111
        // 10000
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

}