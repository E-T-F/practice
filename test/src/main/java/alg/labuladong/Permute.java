package alg.labuladong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        backTrace(nums, trace);
        return res;
    }

    private void backTrace(int[] nums, LinkedList<Integer> trace) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (int num : nums) {
            if (trace.contains(num)) {
                continue;
            }
            trace.add(num);
            backTrace(nums, trace);
            trace.remove(num);
        }

    }
}
