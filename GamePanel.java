import java.awt.event.*;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GamePanel extends JPanel {//implements ActionListener {
    
    static final int ScreenWidth = 500;
    static final int ScreenHeight = 660;
    static final int UnitSize = 100;
    static final int GameUnits = (ScreenWidth * ScreenHeight)/UnitSize;
    final int x[] = new int[GameUnits];
    final int y[] = new int[GameUnits];
    int blankX;
    int blankY;

    GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.WHITE);
        //this.setFocusCycleRoot(true);
        // this.addKeyListener(new MyKeyAdapter());
        //startGame();
    }

/*     public void startGame() {
        newBlank();
        
    } */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i=0;i<=ScreenHeight/UnitSize;i++) {
            g.drawLine(i, i*UnitSize+70, ScreenHeight, i*UnitSize+70);
        }
        for (int i=0;i<=ScreenWidth/UnitSize;i++) {
            g.drawLine(i*UnitSize, 70, i*UnitSize, ScreenHeight);
        }
        g.setColor(Color.white);
        
    }

/*     public void newBlank() {
        blankX = 5;
        blankY = 5;
    } */

    /* @Override
    public void actionPerformed(ActionEvent e) {
        
    } */

    /* public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_Q:
                    
            }
        }
    } */
}
