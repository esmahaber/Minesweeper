/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperGUI;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class Minesweeper {

    JFrame frame;
    Button[][] board = new Button[10][10];
    
    public Minesweeper() {
        frame = new JFrame("Mayın tarlası");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Button button = new Button(row, col);
                frame.add(button);
                board[row][col] = button;
                
            }            
        }
        frame.setVisible(true);
        
    }
}
