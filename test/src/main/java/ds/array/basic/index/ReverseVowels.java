package ds.array.basic.index;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x93lce/
 *
 * @Auther: etf
 * @Date: 2021-01-04 22:19
 * @Description:
 */
public class ReverseVowels {

    public static void main(String[] args) {

        String s = "leetcode";

        System.out.println(reverseVowels2(s));
    }


    public static String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        //耗时比使用switch慢好多
//        Set vowels = Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').collect(Collectors.toSet());

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    public static String reverseVowels(String s) {

        //耗时比使用switch慢好多
        Set vowels = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !vowels.contains(Character.toLowerCase(s.charAt(left)))) {
                left++;
            }
            while (left < right && !vowels.contains(Character.toLowerCase(s.charAt(right)))) {
                right--;
            }
            if (left < right) {
                s = s.substring(0, left) + s.charAt(right) + s.substring(left + 1, right) + s.charAt(left) + s.substring(right + 1);
                left++;
                right--;
            }
        }
        return s;

    }

    /**
     *
     * @param c 用于判断的字符
     * @return 元音字母返回true;
     */
    private static boolean isVowel(char c) {
        switch(c) {
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
            case 'A' :
            case 'E' :
            case 'I' :
            case 'O' :
            case 'U' :
                return true;
        }
        return false;
    }

}
