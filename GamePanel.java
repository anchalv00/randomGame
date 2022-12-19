import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    
    static final int ScreenWidth = 500;
    static final int ScreenHeight = 600;
    static final int UnitSize = 100;
    static final int GameUnits = (ScreenWidth * ScreenHeight)/UnitSize;
    final int x[] = new int[GameUnits];
    final int y[] = new int[GameUnits];
    int blankX;
    int blankY;

    GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.white);
        this.setFocusCycleRoot(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newBlank();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i=0;i<ScreenHeight/UnitSize;i++) {
            g.drawLine(0, i*UnitSize, ScreenHeight, i*UnitSize);
        }
        for (int i=0;i<ScreenWidth/UnitSize;i++) {
            g.drawLine(i*UnitSize, 0, i*UnitSize, ScreenWidth);
        }
        g.setColor(Color.white);
        
    }

    public void newBlank() {
        blankX = 5;
        blankY = 5;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1f2e2ec0a6ab7b3175c27a5c92412c49f860ba76
