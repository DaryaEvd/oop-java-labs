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

   private Color[][] shape = {
           {Color.RED, Color.RED, Color.RED},
           {null, Color.RED, null}
   };

   private int x = 4, y = 0;
   private int normal = 600;
   private int fast = 50;
   private int delatTimeForMovement = normal;
   private long beginTime;

   private int delayX = 0;

   public Board() {
      looper = new Timer(delay, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(!(x + delayX + shape[0].length > 10) && ! (x + delayX < 0)) {
               x += delayX;
            }
            delayX = 0;

            if(System.currentTimeMillis() - beginTime > delatTimeForMovement) {
               y++;
               beginTime = System.currentTimeMillis();
            }
            repaint();
         }
      });
      looper.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
//      super.printComponent(g);
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());
//      g.drawRect(10, 10, getWidth(), getHeight());

      for(int row = 0; row < shape.length; row++) {
         for(int col = 0; col < shape[0].length; col++) {
            if (shape[row][col] != null) {
               g.setColor(shape[row][col]);
               g.fillRect(col * BLOCK_SIZE + x * BLOCK_SIZE, row * BLOCK_SIZE + y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
         }
      }

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
         delatTimeForMovement = fast;
      }
      else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         delayX = 1;
      }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         delayX = -1;
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_DOWN) {
         delatTimeForMovement = normal;
      }
   }
}