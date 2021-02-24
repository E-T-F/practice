package ds.array.basic.classify;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 *
 * @Auther: etf
 * @Date: 2021-02-04 22:09
 * @Description:
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] test = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(new PlusOne().plusOne(test)));
    }

    public int[] plusOne(int[] digits) {
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i];
            digits[i] = (temp + flag) % 10;
            flag = (temp + flag) / 10;
        }
        if (flag > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }


    public int[] plusOne1(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            //最低位加1
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //一旦循环完毕运行到该处，说明有进位
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    /**
     * 输入 [0,0] 输出[0,1] 时无效
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        BigInteger flag = BigInteger.ONE;
        BigInteger num = BigInteger.ZERO;
        for (int i = digits.length - 1; i >= 0; i--) {
            BigInteger temp = flag.multiply(BigInteger.valueOf(digits[i]));
            num = num.add(temp);
            flag = flag.multiply(BigInteger.TEN);
        }
        num = num.add(BigInteger.ONE);
        String[] s = String.valueOf(num).split("");

        return Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
    }

}
