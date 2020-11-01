package ru.job4j.puzzle;

public class Win {
//    public static boolean check(int[][] board) {
//        int i, j;
//        for (i = 0; i < board.length; i++) {
//            j = 0;
//            while (board[i][j] == 1){
//                if (++j == board.length) { return true; }
//            }
//        }
//        for (j = 0; j < board.length; j++) {
//            i = 0;
//            while (board[i][j] == 1) {
//                if (++i == board.length) { return true; }
//            }
//        }
//        return false;
//    }

    public static boolean monoHorizontal(int[][] board, int row) {
    boolean result = true;
    for (int i = 0; i < board[row].length; i++) {
        if (board[row][i] != 1) {
            result = false;
            break;
        }
    }
    return result;
}

    public static boolean monoVertical(int[][] board, int column) {
        boolean result = true;
        for (int i = 0;  i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (monoHorizontal(board, i) || monoVertical(board, i)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
