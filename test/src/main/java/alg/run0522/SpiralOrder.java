package alg.run0522;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 螺旋矩阵
 * 题目描述
 * 给定一个包含 m x n 个元素的矩阵(m 行, n 列)，请按照顺时针螺旋顺序，返回矩阵中的所有元素。 示例 1:
 * 输入: [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {


    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return res;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int r1 = 0, r2 = row - 1;
        int c1 = 0, c2 = column -1;
        while (r1 <= r2 && c1 <= c2) {
            //从左到右
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
            //从上到下
            for (int j = r1 + 1; j <= r2; j++) {
                res.add(matrix[j][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                //从右到左
                for (int m = c2 - 1; m > 0; m--) {
                    res.add(matrix[r2][m]);
                }
                //从下到上
                for (int n = r2 - 1; n > 0; n--) {
                    res.add(matrix[n][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return res;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int total = row * column;
        int cur = 0;
        int curRow = 0, curColumn = 0;
        while (cur < total) {
            res.add(matrix[curRow][curColumn]);
            visited[curRow][curColumn] = true;
            cur++;
            int nextRow = curRow + directions[directionIndex][0];
            int nextColumn = curColumn + directions[directionIndex][1];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= row || nextColumn >= column || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            curRow += directions[directionIndex][0];
            curColumn += directions[directionIndex][1];
        }
        return res;
    }
}
