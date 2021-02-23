package ds.array.basic.classify;

import java.util.Arrays;

/**
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 */
public class MaxSatisfied {

    public static void main(String[] args) {
        int[] cus = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] gru = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        System.out.println(new MaxSatisfied().maxSatisfied(cus, gru, x));
    }


    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i] * (grumpy[i] ^ 1);
        }

        //滑动窗口可加值
        int slip = 0;
        for (int i = 0; i < X; i++) {
            slip += customers[i] * grumpy[i];
        }
        int max_slip = slip;
        for (int i = X; i < customers.length; i++) {
            slip = slip + customers[i] * grumpy[i] - customers[i - X] * grumpy[i - X];
            max_slip = Math.max(max_slip, slip);
        }
        return max_slip + sum;
    }


    /**
     * 暴力
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int max = 0;
        for (int i = 0; i < grumpy.length; i++) {
            int sum = 0;
            int[] tempGrumpy = new int[grumpy.length];
            System.arraycopy(grumpy, 0, tempGrumpy, 0, grumpy.length);
            int end = i + X;
            if (i + X >= grumpy.length - 1) {
                end = grumpy.length - 1;
            }
            Arrays.fill(tempGrumpy, i, end, 0);
            for (int j = 0; j < customers.length; j++) {
                if (tempGrumpy[j] == 0) {
                    sum += customers[j];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }


}