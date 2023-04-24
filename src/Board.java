import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {
   public static final int BOARD_WIDTH = 10;
   public static final int BOARD_HEIGHT = 20;

   public static final int BLOCK_SIZE = 30;
   private Timer looper;
   private Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];

   private Color[][] shape = {
           {Color.RED, Color.RED, Color.RED},
           {null, Color.RED, null}
   };
   public Board() {
      looper = new Timer(500, new ActionListener() {
         int n = 0;
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println(n++);
         }
      });
      looper.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
//      super.printComponent(g);
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.drawRect(10, 10, getWidth(), getHeight());

      for(int row = 0; row < shape.length; row++) {
         for(int col = 0; col < shape[0].length; col++) {
            if(shape[row][col] != null) {
               g.setColor(shape[row][col]);
               g.fillRect(row * BLOCK_SIZE, col * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
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
}