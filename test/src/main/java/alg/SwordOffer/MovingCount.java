package alg.SwordOffer;

import java.util.LinkedList;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(11, 8, 16));

        System.out.println(new MovingCount().getBitSum(16));
    }


    /**
     * visited[i][j] = visited[i-1][j] || visited[i][j-1]
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || getBitSum(i) + getBitSum(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    visited[i][j] |= visited[i - 1][j];
                }
                if (j - 1 >= 0) {
                    visited[i][j] |= visited[i][j - 1];
                }
                ans += visited[i][j] ? 1: 0;
            }
        }
        return ans;
    }


    /**
     * 广度优先遍历1
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        LinkedList<int[]> queue = new LinkedList<>();
        //向右和向下
        int[] dirX = new int[]{0, 1};
        int[] dirY = new int[]{1, 0};
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int ans = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 2; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                if (newX < 0 || newY < 0 || newX >= m || newY >= n
                        || visited[newX][newY] || (getBitSum(newX) + getBitSum(newY)) > k) {
                    continue;
                }
                queue.offer(new int[]{newX, newY});
                visited[newX][newY] = true;
                ans++;
            }
        }
        return ans;
    }



    /**
     * 广度优先遍历2
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount5(int m, int n, int k) {

        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            if (x >= m || y >= n || visited[x][y] || getBitSum(x) + getBitSum(y) > k) {
                continue;
            }
            visited[x][y] = true;
            ans++;
            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y + 1});
        }
        return ans;
    }


    /**
     * 深度优先遍历2
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount6(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return newDfs(m, n, k, 0, 0, visited);
    }

    private int newDfs(int m, int n, int k, int x, int y, boolean[][] visited) {
        if (x >= m || y >= n || visited[x][y] || getBitSum(x) + getBitSum(y) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + newDfs(m, n, k, x + 1, y, visited) + newDfs(m, n, k, x, y + 1, visited);
    }

    /**
     * 深度优先遍历
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    boolean[][] vis;
    int m, n, k;
    public int movingCount4(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        vis = new boolean[m][n];

        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int curXBit, int curYBit) {
        if (i >= m || j >= n || vis[i][j] || curXBit + curYBit > k) {
            return 0;
        }
        vis[i][j] = true;
        int rightSum = dfs(i + 1, j, (i + 1) % 10 != 0 ? curXBit + 1 : curXBit - 8, curYBit);
        int downSum = dfs(i, j + 1, curXBit, (j + 1) % 10 != 0 ? curYBit + 1 : curYBit - 8);
        return 1 + rightSum + downSum;
    }

    public int getBitSum(int val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }


    int count = 0;

    /**
     * 废弃 ，为什么不是数学问题？？？？ 三角形
     *
     * 10 = 1 ， (20,20), k = 10 不满足
     * @param m
     * @param n
     * @param k
     * @return
     */
    public void xxxx(int m, int n, int k) {

    }


}
