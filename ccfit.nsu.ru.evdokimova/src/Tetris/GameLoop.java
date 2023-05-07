package Tetris;

import Model.Block;
import Model.Game;
import Model.GameState;

public class GameLoop extends Thread {
   private boolean running = true;

    @Override
    public void run() {
//        super.run();

        while(running) {

            try {
                if (Game.gameState == GameState.START) {
                    Game.currBlock.setY(Game.currBlock.getY() + 1);

                    if (Game.spawnNewBlock) {
                        Game.block.add(Game.nextBlock);
                        Game.currBlock = Game.nextBlock;
                        Game.nextBlock = new Block();

                        Game.spawnNewBlock = false;
                    }
                }

                if (Game.speedUp) {
                    sleep(1000);
                } else {
                    sleep(100);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
