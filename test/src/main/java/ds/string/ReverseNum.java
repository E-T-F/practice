package ds.string;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 *
 */
public class ReverseNum {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int unit = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && unit > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && unit < -8)) {
                return 0;
            }
            res = res * 10 + unit;
        }
        return res;
    }




    public int reverse1(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = String.valueOf(flag * x).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        try {
            int s = Integer.parseInt(sb.toString());
            return flag * s;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(new ReverseNum().reverse1(-123));
    }
}
