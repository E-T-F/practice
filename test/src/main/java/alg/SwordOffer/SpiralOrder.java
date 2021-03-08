package alg.SwordOffer;

/**
 * @Auther: etf
 * @Date: 2021-03-08 22:25
 * @Description:
 */
public class SpiralOrder {


    public int[] spiralOrder2(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = rows * columns;

        int[] res = new int[total];
        boolean[][] visited = new boolean[rows][columns];
        int row = 0, column = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            res[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + direction[directionIndex][0];
            int nextColumn = column + direction[directionIndex][1];
            if (nextRow < 0 || nextColumn < 0
                    || nextRow >= rows || nextColumn >= columns
                    || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            column += direction[directionIndex][1];
        }
        return res;

    }


    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new int[0];
        }

        int lu = 0;
        int ru = matrix[0].length - 1;
        int ld = 0;
        int rd = matrix.length - 1;

        int[] res = new int[(ru + 1) * (rd + 1)];
        int cur = 0;
        while (true) {
            //right
            for (int i = lu; i <= ru; i++) {
                res[cur++] = matrix[ld][i];
            }
            if (++ld > rd) {
                break;
            }
            //down
            for (int i = ld; i <= rd; i++) {
                res[cur++] = matrix[i][ru];
            }
            if (--ru < lu) {
                break;
            }
            //left
            for (int i = ru; i >= lu; i--) {
                res[cur++] = matrix[rd][i];
            }
            if (--rd < ld) {
                break;
            }
            //up
            for (int i = rd; i >= ld; i--) {
                res[cur++] = matrix[i][lu];
            }
            if (++lu > ru) {
                break;
            }
        }
        return res;

    }
}
