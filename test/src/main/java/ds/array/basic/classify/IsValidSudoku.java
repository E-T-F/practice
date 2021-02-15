package ds.array.basic.classify;


import java.util.HashMap;

/**
 * 有效的数独
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsValidSudoku {


    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num;
                    int index = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[index].put(n, boxes[index].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1
                            || boxes[index].get(n) > 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }


    public boolean isValidSudoku2(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                   int index = (i / 3) * 3 + j / 3;
                   int val = num - '1';
                   if (rows[i][val]++ > 0 || columns[j][val]++ > 0
                           || boxes[index][val]++ > 0) {
                       return false;
                   }
                }

            }
        }
        return true;
    }
}
