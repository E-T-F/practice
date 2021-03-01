package alg.SwordOffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class PrintNumbers {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(2)));
    }

    public int[] printNumbers(int n) {

        int max = (int) Math.pow(10, n) - 1;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    StringBuffer res = new StringBuffer();
    char[] num;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    ;
    int n, start;
    int nine = 0;

    public int[] printNumbers2(int n) {
        start = n - 1;
        this.n = n;
        num = new char[n];
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return Arrays.stream(res.toString().split(",")).mapToInt(Integer::parseInt).toArray();
//        return res.toString();

    }

    private void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                res.append(s).append(",");
            }
            if (n - start == nine) {
                start--;
            }
//            res.append(String.valueOf(num)).append(",");
            return;
        }

        for (char c : loop) {
            if (c == '9') nine++;
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }


    /**
     * 字符串 模拟加法
     *
     * @param n
     * @return
     */
    public int[] printNumbers4(int n) {

        StringBuilder str = new StringBuilder();
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            str.append("0");
        }
        while (!incrementStr(str)) {
            //需去除多余的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            res.add(str.substring(index));

        }
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }

    private boolean incrementStr(StringBuilder str) {
        boolean isOverFlow = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = (char) (str.charAt(i) + 1);
            if (c > '9') {
                //进位归 0
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    //结束
                    isOverFlow = true;
                }
            } else {
                str.replace(i, i + 1, String.valueOf(c));
                break;
            }
        }
        return isOverFlow;
    }

}
