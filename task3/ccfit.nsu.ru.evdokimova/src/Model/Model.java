package Model;

import Controller.Command;
import Model.Figures.*;
import Utils.ColorsConstants;
import Utils.Constants;
import Utils.*;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Utils.Constants.WIDTH;

public class Model implements Subject {
    private static final Logger logger = Logger.getLogger(Model.class.getName());

    private final List<Observer> observers;

    private State currState;
    private int scores;

    private final Color[][] gameField;
    private final byte[] amountFilledCellsInLine;
    private Tetromino curFigure;

    public Model() {
        observers = new LinkedList<>();
        gameField = new Color[Constants.ADDITIONAL_HEIGHT][WIDTH];
        amountFilledCellsInLine = new byte[Constants.ADDITIONAL_HEIGHT];
    }

    public void initNewModel() {
        currState = State.IN_GAME;
        scores = 0;
        initNewFieldCells();
        generateNewFigure();
        Arrays.fill(amountFilledCellsInLine, (byte) 0);
        notifyObservers();
    }

    private void initNewFieldCells() {
        for (int i = 0; i < Constants.ADDITIONAL_HEIGHT; ++i) {
            Arrays.fill(gameField[i], ColorsConstants.EMPTY_CELL);
        }
    }

    public void setModelState(State newModelState) {
        currState = newModelState;
    }

    public void handleRequest(Command command) {
        if (currState.equals(State.IN_THE_END) || currState.equals(State.IN_PAUSE)) {
            return;
        }
        boolean modelHasChanged = false;

        switch (command) {
            case GO_DOWN -> {
                logger.log(Level.INFO, "Model go down");
                modelHasChanged = curFigure.goDown(gameField);

                if (!modelHasChanged) {
                    updateCountFilledCellsInLine();
                    int countOfFilledLines = countAmountOfFilledLines();
                    if (countOfFilledLines > 0) {
                        earnPoints(countOfFilledLines);
                        destroyFilledLines(countOfFilledLines);
                    }
                    if (isGameEnd()) {
                        currState = State.IN_THE_END;
                    } else {
                        generateNewFigure();
                    }
                    notifyObservers();
                }
            }
            case GO_LEFT -> {
                modelHasChanged = curFigure.goLeft(gameField);
                logger.log(Level.INFO, "Model turn left");
            }
            case GO_RIGHT -> {
                modelHasChanged = curFigure.goRight(gameField);
                logger.log(Level.INFO, "Model turn right");
            }
            case DO_ROTATION -> {
                modelHasChanged = curFigure.rotateRight(gameField);
                System.err.println("Model rotated");
            }
            default -> { }
        }

        if (modelHasChanged) {
            logger.log(Level.INFO, "Model changed");
            notifyObservers();
        }
    }

    private boolean isGameEnd() {
        return amountFilledCellsInLine[3] > 0;
    }

    private void destroyFilledLines(int countOfFilledLines) {
        for (int i = 0; i < countOfFilledLines; ++i) {
            for (int x = Constants.ADDITIONAL_HEIGHT - 1; x >= 4; --x) {
                if (amountFilledCellsInLine[x] == 10) {
                    destroyLine(x);
                }
            }
        }
    }

    private void destroyLine(int lineNum) {
        System.arraycopy(amountFilledCellsInLine, 0, amountFilledCellsInLine, 1, lineNum);
        for (int x = lineNum; x >= 4; --x) {
            System.arraycopy(gameField[x - 1], 0, gameField[x], 0, WIDTH);
        }
    }

    private void earnPoints(int amountShootedLines) {
        switch (amountShootedLines) {
            case 1 -> scores += 100;
            case 2 -> scores += 200;
            case 3 -> scores += 300;
            default -> scores += 400;
        }

        logger.log(Level.INFO, "Scores up!");
    }

    private void updateCountFilledCellsInLine() {
        for (Coordinates figureSquare : curFigure.getTetrominoCoordsFromField()) {
            ++amountFilledCellsInLine[figureSquare.getX()];
        }
    }

    private int countAmountOfFilledLines() {
        int amountOfFilledLines = 0;
        for (int x = 4; x < Constants.ADDITIONAL_HEIGHT; ++x) {
            if (amountFilledCellsInLine[x] == WIDTH) {
                ++amountOfFilledLines;
            }
        }
        return amountOfFilledLines;
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) {
            logger.log(Level.SEVERE, "Can't register obj cause it is null");
            throw new NullPointerException("Null observer");
        }
        if(!observers.contains(obj)) {
            observers.add(obj);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updateEvent();
        }
    }

    private void generateNewFigure() {
        curFigure = Tetromino.generateNewFigure();
    }

    public Color[][] getGameField() {
        return gameField;
    }

    public int getScores() {
        return scores;
    }

    public State getCurrState() {
        return currState;
    }
}