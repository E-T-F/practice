package alg.SwordOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("abc")));
    }

    LinkedList<String> res = new LinkedList<>();
    char[] chars;

    public String[] permutation(String s) {

        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int pos) {
        //全部位置已固定
        if (pos == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }

        //当前位置有重复字符情况，可优化剪枝
        HashSet<Character> existed = new HashSet<>();
        for (int i = pos; i < chars.length; i++) {
            if (existed.contains(chars[i])) {
                continue;
            }
            existed.add(chars[i]);
            swap(chars, pos, i);
            //固定下一位置
            dfs(pos + 1);
            //恢复原样
            swap(chars, pos, i);
        }

    }

    private void swap(char[] swap, int i, int j) {
        char temp = swap[i];
        swap[i] = swap[j];
        swap[j] = temp;
    }

}
