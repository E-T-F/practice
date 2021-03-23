package alg.SwordOffer;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 *
 * @Auther: etf
 * @Date: 2021-03-23 23:06
 * @Description:
 */
public class FindNthDigit {

    public int findNthDigit(int n) {

        //数字以0123456789101112131415…的格式序列化到一个字符序列中
        // 1位 1-9     9   9
        // 2位 10-99  90   180
        // 3位 100-999 900 2700

        int digit = 1;
        long count = 9;
        long start = 1;
        //确认所在数位的位数
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }

        //确认所求数位所在的数字
        long num = start + (n - 1) / digit;
        //数字中的第几位
        int pos = (n - 1) % digit;

        return String.valueOf(num).charAt(pos) - '0';
    }

}
