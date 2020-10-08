
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class Minesweeper {

    int rowNumber, colNumber, size;
    int[][] map;
    int[][] board;
    boolean gameStart = false;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Minesweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
    }

    public void run() {
        int row, col, success = 0;
        prepareGame();
        print(map);
        gameStart = true;
        System.out.println("Oyun başladı");
        while (gameStart) {
            print(board);
            System.out.println("Oyuncu satır seçimi: ");
            row = scanner.nextInt();
            System.out.println("Oyuncu sütun seçimi: ");
            col = scanner.nextInt();

            if (row < 0 || row >= rowNumber) {
                System.out.println("Geçersiz koordinat!");
                continue;
            }
            if (col < 0 || col >= colNumber) {
                System.out.println("Geçersiz koordinat!");
                continue;
            }

            if (map[row][col] != -1) {
                checkMine(row, col);
                success++;
                if (success == (size - (size / 4))) {
                    System.out.println("Tebrikler Oyunu Kazandınız!");
                    break;
                }
            } else {
                gameStart = false;
                System.out.println("Oyun Bitti!");
            }
        }
    }

    public void prepareGame() {
        int randomRow, randomCol, count = 0;

        while (count != (size / 4)) {
            randomRow = random.nextInt(rowNumber);
            randomCol = random.nextInt(colNumber);
            if (map[randomRow][randomCol] != -1) {
                map[randomRow][randomCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkMine(int row, int col) {
        if (map[row][col] == 0) {
            if ((col < colNumber - 1) && (map[row][col + 1] == -1)) {
                board[row][col]++;
            }
            if ((col > 0) && (map[row][col - 1]) == -1) {
                board[row][col]++;
            }
            if ((row > 0) && (map[row - 1][col] == -1)) {
                board[row][col]++;
            }
            if ((row < colNumber - 1) && (map[row + 1][col] == -1)) {
                board[row][col]++;
            }

            if (board[row][col] == 0) {
                board[row][col] = -2;
            }
        }

    }
}
