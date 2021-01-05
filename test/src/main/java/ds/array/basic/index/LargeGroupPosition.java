package ds.array.basic.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * @Auther: etf
 * @Date: 2021-01-05 22:08
 * @Description:
 */
public class LargeGroupPosition {


    public static void main(String[] args) {

        String s = "aaa";
        System.out.println(largeGroupPositions2(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {

        char[] chars = s.toCharArray();
        if (chars.length <= 2) {
            return Collections.emptyList();
        }
        int left = 0;
        int right = 1;
        int count = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (right < chars.length) {
            if (chars[left] == chars[right]) {
                right++;
                count++;
            } else {
                if (count >= 3) {
                    res.add(Arrays.asList(left, right - 1));
//                    res.add(Stream.of(left, right - 1).collect(Collectors.toList()));
                    System.out.println(chars[left] + " :" + count);
                }
                left = right;
                right++;
                count = 1;
            }
        }
        //最后一次刚好满足，已退出循环
        if (count >= 3) {
            res.add(Stream.of(left, right - 1).collect(Collectors.toList()));
        }
        return res;
    }


    public static List<List<Integer>> largeGroupPositions2(String s) {

        char[] chars = s.toCharArray();
        int pos = 0;
        int left = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (left < chars.length) {

            int count = 1;
            left = pos;

            while (pos < chars.length - 1 && chars[pos] == chars[pos + 1]) {
                pos++;
                count++;
            }

            if (count >= 3) {
                res.add(Arrays.asList(left, pos));
            }
            pos++;
        }
        return res;
    }
}