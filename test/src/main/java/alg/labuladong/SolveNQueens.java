package alg.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 */
public class SolveNQueens {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backTrace(board, 0);
        return res;
    }

    private void backTrace(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToList(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backTrace(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {

        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        //左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> charToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] chars : board) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }

}
