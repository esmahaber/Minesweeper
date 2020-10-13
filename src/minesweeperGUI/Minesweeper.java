/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperGUI;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class Minesweeper {

    JFrame frame;
    Button[][] board = new Button[10][10];
    ImageIcon imageIcon;
    
    public Minesweeper() {
        frame = new JFrame("Mayın tarlası");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Button button = new Button(row, col);
                frame.add(button);
                board[row][col] = button;

            }
        }

        generateMine();
        print();
        frame.setVisible(true);
    }

    public void generateMine() {
        int i = 0;
        while (i < 10) {
            int randomRow = (int) (Math.random() * board.length);
            int randomCol = (int) (Math.random() * board[0].length);

            while (board[randomRow][randomCol].isMine()) {
                randomRow = (int) (Math.random() * board.length);
                randomCol = (int) (Math.random() * board[0].length);
            }
            board[randomRow][randomCol].setMine(true);
            i++;
        }
    }

    public void print() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMine()) {
                    imageIcon = new ImageIcon("C:\\javaDemos\\Minesweeper\\src\\mine.png");
                    
                    Image im = imageIcon.getImage();
                    Image im2 = im.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    
                    board[row][col].setIcon(new ImageIcon(im2));
                   
                }

            }
        }
    }
}
