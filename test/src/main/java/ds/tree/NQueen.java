package ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NQueen {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<StringBuffer> track = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            track.add(sb);
        }
        backTrace(track, 0);
        return res;
    }

    private void backTrace(List<StringBuffer> track, int row) {
        if (row == track.size()) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                temp.add(track.get(i).toString());
            }
            res.add(temp);
            return;
        }


        int n = track.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(track, row, col)) {
                continue;
            }
            track.get(row).setCharAt(col, 'Q');
            backTrace(track, row + 1);
            track.get(row).setCharAt(col, '.');
        }

    }

    private boolean isValid(List<StringBuffer> track, int row, int col) {

        //列
        for (int i = 0; i < row; i++) {
            if (track.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        //左上
        for (int x = row - 1, y = col - 1; x >= 0 && y >= 0; x--, y--) {
            if (track.get(x).charAt(y) == 'Q') {
                return false;
            }
        }
        //右上
        int colSize = track.get(0).length();
        for (int x = row - 1, y = col + 1; x >= 0 && y < colSize; x--, y++) {
            if (track.get(x).charAt(y) == 'Q') {
                return false;
            }
        }
        return true;
    }

}
