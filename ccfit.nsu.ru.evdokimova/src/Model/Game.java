package Model;

import java.util.ArrayList;

public class Game {
    public static boolean spawnNewBlock = false;
    public static boolean speedUp = false;

    public static ArrayList<Block> block = new ArrayList<Block>();
    public static Block currBlock, nextBlock;
    public static int[][] map = new int[10][10];

    public static int score = 0;
    public static int hightScore = 0;
    public static int scoreToAdd = 0;

    public static GameState gameState = GameState.START;

    public static void clear() {
        for(int x = 0; x < map.length; x++) {
            for(int y = 0; y < map[x].length; y++) {
                map[x][y] = 0;
            }
        }
        score = 0;

    }


}
