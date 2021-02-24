package alg.SwordOffer;

/**
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