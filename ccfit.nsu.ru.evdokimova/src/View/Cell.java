package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {
   private int size;
   private Color color;

   public Cell(Color color, int size) {
       this.color= color;
       this.size = size;
   }

   @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);

       g.setColor(color);
       g.fillRect(0, 0, size, size);
   }
}
