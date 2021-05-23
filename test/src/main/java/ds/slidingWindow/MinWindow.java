package ds.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindow().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        char[] chars = s.toCharArray();
        int start = 0;
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            //待加入的字符
            char c = chars[right];
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                //该字符已经满足，有效字符+1
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }

            //是否可以左移优化
            while (needs.size() == valid) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                //待移出的字符
                char re = chars[left];
                left++;
                //更新窗口内数据
                if (needs.containsKey(re)) {
                    if (needs.get(re).equals(windows.get(re))) {
                        valid--;
                    }
                    windows.put(re, windows.get(re) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
