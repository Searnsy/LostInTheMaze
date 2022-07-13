package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    char board[][];
    public Board(String file) {
        this.board = new char[10][10];
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            for(int i = 0; i < 10; i++) {
                String line = fileReader.readLine();
                for(int j = 0; j < 10; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void printBoard() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board board = new Board("src/Model/board.txt");
    }
}
