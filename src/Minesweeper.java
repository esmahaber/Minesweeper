
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
        prepareGame();
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
}
