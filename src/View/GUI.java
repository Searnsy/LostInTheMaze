package View;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private char current_hint = 'A';

    public GUI() {
        Board board = new Board("src/Model/sample_playing_board.txt");

        JFrame frame = new JFrame("Lost In The Maze");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JPanel board_display = new JPanel();
        board_display.setLayout(new GridLayout(11,11));
        JLabel top_left_label = new JLabel();
        top_left_label.setPreferredSize(new Dimension(5, 5));
        board_display.add(top_left_label);
        for(int i = 0; i < 10; i++) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(50, 5));
            label.setText((char)('A' + i) + "");
            board_display.add(label);
        }
        for(int i = 0; i < 10; i++) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(5, 50));
            label.setText(i + "");
            board_display.add(label);
            for(int j = 0; j < 10; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50,50));
                board_display.add(new GameTile(this, board.board[i][j]));
            }
        }

        panel.add(board_display);


        frame.pack();
        frame.setVisible(true);
    }

    public char getCurrentHint() {
        return current_hint;
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
