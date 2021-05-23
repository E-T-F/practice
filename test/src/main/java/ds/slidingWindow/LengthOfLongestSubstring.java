package ds.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            //更新窗口数据
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            //左移优化
            while (windows.get(c) > 1) {
                char re = s.charAt(left);
                left++;
                windows.put(re, windows.get(re) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }



    //s 必须只包含26个字母
    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[27];
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            chars[c - 'a']++;

            //左移
            while (chars[c - 'a'] > 1) {
                char re = s.charAt(left);
                left++;
                chars[re - 'a']--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
