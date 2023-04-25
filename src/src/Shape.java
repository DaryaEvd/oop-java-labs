import java.awt.*;

public class Shape {
    private int x = 4, y = 0;
    private int normal = 600;
    private int fast = 50;
    private int delatTimeForMovement = normal;
    private long beginTime;

    private int delayX = 0;
    private boolean collision = false;

    private int [][] coords;
    public Shape(int[][] coords) {
        this.coords = coords;
    }
    public void update() {
        if(collision) {
            return;
        }

        if(!(x + delayX + coords[0].length > 10) && ! (x + delayX < 0)) {
            x += delayX;
        }
        delayX = 0;

        if(System.currentTimeMillis() - beginTime > delatTimeForMovement) {
            if(!(y + 1 + coords.length > Board.BOARD_HEIGHT)) {
                y++;
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
        delayX = 1;
    }

    public void moveLeft() {
        delayX = -1;
    }
}



