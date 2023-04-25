import java.awt.*;

public class Shape {
    private int x = 4, y = 0;
    private int normal = 600;
    private int fast = 50;
    private int delatTimeForMovement = normal;
    private long beginTime;

    private int deltaX = 0;
    private boolean collision = false;

    private int [][] coords;
    private Board board;
    private Color color;

    public Shape(int[][] coords, Board board, Color color) {
        this.coords = coords;
        this.board = board;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void reset() {
        this.x = 4;
        this.y = 0;
        collision = false;
    }
    public void update() {

        if(collision) {
            for(int row = 0; row < coords.length; row++) {
               for(int col = 0; col < coords[0].length; col++) {
                   if(coords[row][col] != 0) {
                        board.getBoard()[y + row][x + col] = color;
                   }
               }
            }

            board.setCurrShape();
            return;
        }

        // check horizonal moving
        boolean moveX = true;
        if(!(x + deltaX + coords[0].length > 10) && ! (x + deltaX < 0)) {
           for(int row = 0; row < coords.length; row++) {
               for(int col = 0; col < coords[row].length; col++) {
                   if(coords[row][col] != 0) {
                        if(board.getBoard()[y + row][x + deltaX + col] != null) {
                            moveX = false;
                        }
                   }
               }
           }
           if(moveX) {
               x += deltaX;
           }
        }
        deltaX = 0;

        if(System.currentTimeMillis() - beginTime > delatTimeForMovement) {
            // vertical movement
            if(!(y + 1 + coords.length > Board.BOARD_HEIGHT)) {
               for(int row = 0; row < coords.length; row++) {
                   for(int col = 0; col < coords[row].length; col++) {
                       if(coords[row][col] != 0) {
                           if(board.getBoard()[y + 1 + row][x + deltaX + col] != null) {
                               collision = true;
                           }
                       }
                   }
               }
               if(!collision) {
                   y++;
               }
            }
            else {
                collision = true;
            }
            beginTime = System.currentTimeMillis();
        }
    }

    public void render(Graphics g) {

        for (int row = 0; row < coords.length; row++) {
            for (int col = 0; col < coords[0].length; col++) {
                if (coords[row][col] != 0) {
                    g.setColor(Color.red);
                    g.fillRect(col * Board.BLOCK_SIZE + x * Board.BLOCK_SIZE,
                            row * Board.BLOCK_SIZE + y * Board.BLOCK_SIZE,
                            Board.BLOCK_SIZE,
                            Board.BLOCK_SIZE);
                }
            }
        }
    }

    public void speedUp() {
        delatTimeForMovement = fast;
    }

    public void speedDown() {
        delatTimeForMovement = normal;
    }

    public void moveRight() {
        deltaX = 1;
    }

    public void moveLeft() {
        deltaX = -1;
    }
}



