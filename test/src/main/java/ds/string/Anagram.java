package ds.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 */
public class Anagram {


    public boolean isAnagram1(String s, String t) {
        HashMap<Character, Integer> statisticMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (Character c : s.toCharArray()) {
            statisticMap.put(c, statisticMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            statisticMap.put(c, statisticMap.getOrDefault(c, 0) - 1);
            if (statisticMap.get(c) < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    public static void main(String[] args) {
        String s= "aabs";
        String t= "sdsf";

        new Anagram().isAnagram3(s, t);
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram4(String s, String t) {
        HashMap<Character, Integer> firstStr = new HashMap<>();
        HashMap<Character, Integer> secondStr = new HashMap<>();

        if (t.length() != s.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            firstStr.put(c, firstStr.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            secondStr.put(c, secondStr.getOrDefault(c, 0) + 1);
        }

        if (firstStr.keySet().size() != secondStr.keySet().size()) {
            return false;
        }

        for (Character c : firstStr.keySet()) {
            if (!firstStr.get(c).equals(secondStr.get(c))) {
                return false;
            }
        }

        return true;
    }


}
