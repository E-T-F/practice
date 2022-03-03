package alg.date.March.date0303;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，
 * 或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solve {

    int row, col;

    //将边上的'O'替换为'#',然后dfs 判断与其相邻的替换'#'，剩下的'O'替换为'X'，然后将'#'替换回'O'
    public void solveByBFS(char[][] board) {
        if (board.length <= 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        //将首列和最后一列dfs替换
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }


        //将首行和最后一行dfs替换
        for (int j = 0; j < col; j++) {
            dfs(board, 0, j);
            dfs(board, row - 1, j);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i >= row || j >= col || i < 0 || j < 0 || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, 01}};
        for (int k = 0; k < 4; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            dfs(board, x, y);
        }
    }

    //思路：将边上的'0'及与其连通的'0'统一与 虚拟节点virtual连通，剩下的全部非连通'0'都替换为'x'
    public void solve(char[][] board) {
        int n = board[0].length;
        int m = board.length;
        UnionFind uf = new UnionFind(m * n + 1);
        int virtual = m * n;

        //将首行与最后一行的'0'与虚拟节点连通
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(virtual, i);
            }
            if (board[m - 1][i] == 'O') {
                uf.union(virtual, n * (m - 1) + i);
            }
        }
        //将首列与最后一列的'0'与虚拟节点连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(virtual, i * n);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(virtual, i * n + n - 1);
            }
        }
        //开始遍历连通其它节点
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    //将此节点与上下左右的'0'连通
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                //未连通 替换为'x'
                if (!uf.connected(virtual, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

}
