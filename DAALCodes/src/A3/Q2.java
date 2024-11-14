// package A3;
import java.util.Scanner;

public class Q2 {

    static int tileNum = 0;
    static char[][] board;

    private static void place(int x1, int y1, int x2, int y2, int x3, int y3) {
        tileNum++;
        board[x1][y1] = '*';
        board[x2][y2] = '*';
        board[x3][y3] = '*';
    }

    private static void tile(int size, int r, int c) {
        if (size == 2) {
            tileNum++;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[r + i][c + j] == ' ') {
                        board[r + i][c + j] = '*';
                    }
                }
            }
            return;
        }

        int mr = -1, mc = -1;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != ' ') {
                    mr = i;
                    mc = j;
                    break;
                }
            }
            if (mr != -1) break;
        }

        if (mr < r + size / 2 && mc < c + size / 2) {
            place(r + size / 2, c + size / 2 - 1, r + size / 2, c + size / 2, r + size / 2 - 1, c + size / 2);
        } else if (mr >= r + size / 2 && mc < c + size / 2) {
            place(r + size / 2 - 1, c + size / 2, r + size / 2, c + size / 2, r + size / 2 - 1, c + size / 2 - 1);
        } else if (mr < r + size / 2 && mc >= c + size / 2) {
            place(r + size / 2, c + size / 2 - 1, r + size / 2, c + size / 2, r + size / 2 - 1, c + size / 2 - 1);
        } else if (mr >= r + size / 2 && mc >= c + size / 2) {
            place(r + size / 2 - 1, c + size / 2, r + size / 2, c + size / 2 - 1, r + size / 2 - 1, c + size / 2 - 1);
        }

        tile(size / 2, r, c + size / 2);
        tile(size / 2, r, c);
        tile(size / 2, r + size / 2, c);
        tile(size / 2, r + size / 2, c + size / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mr = sc.nextInt();
        int mc = sc.nextInt();
        sc.close();

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }

        board[mr][mc] = '+';

        tile(n, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
