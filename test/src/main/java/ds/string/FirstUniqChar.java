package ds.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new FirstUniqChar().firstUniqChar(s));
    }


    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> existed = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (existed.containsKey(c)) {
                existed.put(c, -1);
            } else {
                existed.put(c, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : existed.entrySet()) {
            int val = entry.getValue();
            if (val != -1 && val < first) {
                first = val;
            }
        }

        if (n == first) {
            return -1;
        }
        return first;

    }

    /**
     * 可能返回非第一个
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {

        char[] temp = s.toCharArray();
        HashMap<Character, Integer> existed = new HashMap<>();
        for (char c : temp) {
            existed.put(c,
                    existed.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < temp.length; i++) {
            if (existed.get(temp[i]).equals(1)) {
                return i;
            }
        }
        return -1;
    }
}
