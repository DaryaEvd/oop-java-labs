import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements KeyListener {
   private static final int FPS = 60;
   private static int delay = 1000 / FPS;
   public static final int BOARD_WIDTH = 10;
   public static final int BOARD_HEIGHT = 20;

   public static final int BLOCK_SIZE = 30;
   private Timer looper;
   private Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];

   private int[][] shape1 = {
           {1, 1, 1},
           {0, 1, 0}
   };

   private Shape shape = new Shape(shape1);
   public Board() {
      looper = new Timer(delay, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            update();
            repaint();
         }
      });
      looper.start();
   }

   private void update() {
      shape.update();
   }

   @Override
   protected void paintComponent(Graphics g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());

      shape.render(g);

      g.setColor(Color.white);
      for(int row = 0; row < BOARD_HEIGHT; row++) {
         g.drawLine(0, row * BLOCK_SIZE, BLOCK_SIZE * BOARD_WIDTH, BLOCK_SIZE * row);
      }

     for(int col = 0; col < BOARD_WIDTH + 1; col++) {
        g.drawLine(col * BLOCK_SIZE, 0, BLOCK_SIZE * col, BLOCK_SIZE * BOARD_HEIGHT);
     }

   }

   @Override
   public void keyTyped(KeyEvent e) {

   }

   @Override
   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_DOWN) {
         shape.speedUp();
      }
      else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         shape.moveRight();
      }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         shape.moveLeft();
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_DOWN) {
         shape.speedDown();
      }
   }
}