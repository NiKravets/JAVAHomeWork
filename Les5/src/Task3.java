/*На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску.*/
public class Task3 {
    static int queenCount = 8;
    static int[] arrayQueens = new int[queenCount];
    static int size = 8;


    public static void main(String args[]) {
        chessBoard(0, size);
    }

    public static boolean checkQueen(int row, int col) {

        for (int i = 0; i < row; i++) {
            if (arrayQueens[i] == col || arrayQueens[i] == col + (row - i) || arrayQueens[i] == col+ (i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void putQueens(int[] arrayQueens) {
        for (int i = 0; i < arrayQueens.length; i++) {
            for (int j = 0; j < arrayQueens.length; j++) {
                if (arrayQueens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void chessBoard(int row, int size) {
        int count = 0;
        for (int col = 0; col < size; col++) {
            if (checkQueen(row, col)) {
                arrayQueens[row] = col;
                if (row == size - 1) {
                    putQueens(arrayQueens);
                } else {
                    chessBoard(row+1, size);

                }
            }
        }
    }
}