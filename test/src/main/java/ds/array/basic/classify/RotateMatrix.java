package ds.array.basic.classify;

import java.util.Arrays;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateMatrix {

    // key: matrix_new[col][n−row−1]=matrix[row][col]

    /**
     * 1. 水平翻转 ： (i,j) -> (n - i - 1, j)
     * 2. 对角线翻转: (n - i - 1, j) -> (j, n - i - 1)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //1 水平翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //2 对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    /**
     * (i，j) -> (j, n - i - 1)
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res[j][len - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; ++i) {
            System.arraycopy(res[i], 0, matrix[i], 0, len);
        }
    }
}
