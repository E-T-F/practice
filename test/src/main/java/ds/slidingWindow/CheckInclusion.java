package ds.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class CheckInclusion {

    public static void main(String[] args) {
        String s = "ab";
        String t = "eidboaoo";
        System.out.println(new CheckInclusion().checkInclusion(s, t));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();

        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            //加入窗口的数据
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            //是否可以左移优化
            while (right - left >= s1.length()) {
                //存在结果
                if (valid == needs.size()) {
                    return true;
                }
                char re = s2.charAt(left);
                left++;
                if (needs.containsKey(re)) {
                    if (needs.get(re).equals(windows.get(re))) {
                        valid--;
                    }
                    windows.put(re, windows.get(re) - 1);
                }

            }
        }
        return false;

    }
}
