
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
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, column;
        System.out.println("Mayın Tarlasına Hoşgldiniz!");
        System.out.println("Lütfen oyun boyunu giriniz");
        System.out.println("Satır sayısı");
        row = scanner.nextInt();
        System.out.println("Sütun sayısı");
        column = scanner.nextInt();
        
        Minesweeper minesweeper = new Minesweeper(row, column);
    }
}
