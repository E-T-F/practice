package ds.intervals;

import com.alibaba.fastjson.JSON;
import ds.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 */
public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });


        int left = intervals[0][0];
        int right = intervals[0][1];
        List<List<Integer>> deletion = new ArrayList<>();
        int deleteNum = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            //覆盖区间
            if (intv[0] >= left && intv[1] <= right) {
                deleteNum++;
                deletion.add(Arrays.asList(intv[0], intv[1]));
            } else if (intv[1] >= right) {
                //合并扩大区间
                right = intv[1];
            } else if (intv[0] > right) {
                //不相交 , 更新线段
                left = intv[0];
                right = intv[1];
            }
        }
        return intervals.length - deleteNum;
    }
}
