package alg.SwordOffer;

public class Exist {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchWord(board, word,  i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int row, int column, int index) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || word.charAt(index) != board[row][column]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        board[row][column] = ' ';
        boolean res = searchWord(board, word, row - 1, column, index + 1)
                || searchWord(board, word, row, column - 1, index + 1)
                || searchWord(board, word, row + 1, column, index + 1)
                || searchWord(board, word, row, column + 1, index + 1);

        board[row][column] = word.charAt(index);
        return res;
    }
}
