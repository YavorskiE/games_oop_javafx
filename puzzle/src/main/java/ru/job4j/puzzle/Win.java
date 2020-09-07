package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        int i, j;
        for (i = 0; i < board.length; i++) {
            j = 0;
            while (board[i][j] == 1){
                if (++j == board.length) { return true; }
            }
        }
        for (j = 0; j < board.length; j++) {
            i = 0;
            while (board[i][j] == 1) {
                if (++i == board.length) { return true; }
            }
        }
        return false;
    }
}
