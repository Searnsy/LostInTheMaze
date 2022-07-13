package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameTile extends JButton implements ActionListener {
    char tile_type;
    boolean isPlayer;
    Color playerColor;
    ArrayList<Character> tracking_hints;

    public GameTile(char tile_type) {
        this.setPreferredSize(new Dimension(50, 50));
        this.tile_type = tile_type;
        this.isPlayer = false;
        this.playerColor = Color.LIGHT_GRAY;
        tracking_hints = new ArrayList<>();

        if(tile_type == 'W'){
            setEnabled(false);
        }
        addActionListener(this);
    }

    public GameTile(char tile_type, Color playerColor) {
        this(tile_type);
        this.isPlayer = true;
        this.playerColor = playerColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBorder(new LineBorder(Color.GRAY, 1));
        switch(tile_type) {
            case 'W':
                setBackground(Color.GRAY);
                break;
            case 'E':
                setBackground(Color.LIGHT_GRAY);
                break;
            case '|':
                setBackground(Color.LIGHT_GRAY);
                g.setColor(Color.RED);
                g.fillRect(24, 0, 2, 50);
                break;
            case '-':
                setBackground(Color.LIGHT_GRAY);
                g.setColor(Color.RED);
                g.fillRect(0, 24, 50, 2);
                break;
            case '+':
                setBackground(Color.LIGHT_GRAY);
                g.setColor(Color.RED);
                g.fillRect(24, 0, 2, 50);
                g.fillRect(0, 24, 50, 2);
                break;
        }
        if(this.isPlayer) {
            g.setColor(playerColor);
            g.fillOval(12, 25, 26, 50);
            g.fillOval(15, 10, 20, 20);
        }

        String hint = "";
        for(int i = 0; i < tracking_hints.size() - 1; i++) {
            hint += tracking_hints.get(i) + ", ";
        }
        if(tracking_hints.size() > 0) {
            hint += tracking_hints.get(tracking_hints.size() - 1);
        }
        g.setColor(Color.RED);
        g.drawString(hint, 2, 12);
    }

    public void actionPerformed(ActionEvent e) {
        this.tracking_hints.add('A');
        this.repaint();
    }
}
