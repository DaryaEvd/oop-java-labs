import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        try {
            logManager.readConfiguration(new FileInputStream( "./ccfit.nsu.ru.evdokimova/src/MyLogger/logger.properties"));
            logger.log(Level.INFO, "Logger initialized");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Can't load logger file :(");
            throw new RuntimeException(e);
        }

        Tetris.getInstance().run();

        logger.log(Level.FINE, "End of successful work!");

    }
}