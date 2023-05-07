package View;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private final int WIDTH = 10;
    private final int HEIGHT = 24;

//    private final Rectangle[][] field;
//    public GameBoard() {
//       this.field = new Rectangle[WIDTH][HEIGHT];
//
//       for(int i = 0; i < this.WIDTH; i++) {
//           for(int j = 0; j < this.HEIGHT; j++) {
//              this.field[i][j] = new Rectangle();
//                this.field[i][j].
//           }
//       }
//    }

   public void paintComponent(Graphics g) {
       super.paintComponent(g);

       Graphics2D g2 = (Graphics2D) g;
       g2.setColor(Color.YELLOW);
       g2.drawRect(WIDTH, HEIGHT, WIDTH, HEIGHT);

   }
}
