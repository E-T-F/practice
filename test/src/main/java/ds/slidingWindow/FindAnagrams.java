package ds.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 */
public class FindAnagrams {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(new FindAnagrams().findAnagrams(s, t));
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }

            //左移优化
            while (right - left >= p.length()) {
                if (needs.size() == valid) {
                    res.add(left);
                }
                char re = s.charAt(left);
                left++;
                if (needs.containsKey(re)) {
                    if (needs.get(re).equals(windows.get(re))) {
                        valid--;
                    }
                    windows.put(re, windows.get(re) - 1);
                }

            }
        }
        return res;


    }
}
