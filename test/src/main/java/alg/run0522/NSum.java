package alg.run0522;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NSum {

    public List<List<Integer>> NSum(int[] nums, int target) {
        Arrays.sort(nums);
        return NSumTarget(nums, 4, 0, target);
    }

    private List<List<Integer>> NSumTarget(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (n < 2 || size < n) {
            return res;
        }

        if (n == 2) {
            //TwoSum
            int low = start, high = size - 1;
            while (low < high) {
                int temp = nums[low] + nums[high];
                int left = nums[low], right = nums[high];
                if (temp < target) {
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                } else if (temp > target) {
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                } else {
                    res.add(Arrays.asList(nums[low], nums[high]));
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                }
            }
        } else {
            //recursion
            for (int i = start; i < size; i++) {
                List<List<Integer>> sub = NSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(arr);
                    res.add(temp);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
