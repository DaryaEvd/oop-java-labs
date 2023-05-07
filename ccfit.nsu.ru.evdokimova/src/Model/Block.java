package Model;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Block {

    private static final Logger logger = Logger.getLogger(Block.class.getName());

   BlockType type;
   int x, y, size, rotation = 0;

   int [][][] bounds;

   Color color;
   boolean movable = true;

   public Block() {
       type = BlockType.random();
       switch (type) {
           case I -> {
               size = 4;
           }
           case O -> {
               size = 2;
           }
           default -> {
               size = 3;
           }
       }

       switch (type) {
           case O -> {
               color = Color.YELLOW;
           }
           case I -> {
               color = Color.CYAN;
           }
           case J -> {
               color = Color.BLUE;
           }
           case L -> {
               color = Color.ORANGE;
           }
           case S -> {
               color = Color.GREEN;
           }
           case T -> {
               color = new Color(102, 0, 153);
           }
           case Z -> {
               color = Color.RED;
           }
       }

       x = 4;
       y = -2;

       try {
           bounds = buildBlock(type);
       } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File with figure");
//           throw new RuntimeException(e);
       }
   }

   public void rotate() {
       rotation++;
       if(rotation == 4) {
           rotation = 0;
       }
   }
   public int[][][] buildBlock(BlockType type) throws FileNotFoundException {
       int [][][] bounds;

       switch (type) {
           case I -> {
               bounds = new int[4][4][4];
           }
           case O -> {
                bounds = new int[4][2][2];
           }
           default -> {
               bounds = new int[4][3][3];
           }
       }

       File file = new File("./resources/Figures/" + type + ".txt");
       try (Scanner scanner = new Scanner(file)) {
           for(int variant = 0; variant < 4; variant++) {
               for(int i = 0; i < bounds[0].length; i++) {
                   if(scanner.hasNext()) {
                       String [] strRow = scanner.next().split("");
                       int[] row = new int[bounds[0].length];

                       for(int j = 0; j < row.length; j++) {
                           row[j] = Integer.parseInt(strRow[j]);
                           bounds[variant][i][j] = row[j];
                       }
                   }
               }
           }
       }


       return bounds;
   }

    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int[][][] getBounds() {
        return bounds;
    }

    public void setBounds(int[][][] bounds) {
        this.bounds = bounds;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
}
