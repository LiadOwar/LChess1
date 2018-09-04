package com.lchess.game;

import com.lchess.UI.ConsoleUI;
import com.lchess.common.Logger;
import com.lchess.engine.board.Board;
import com.lchess.engine.board.BoardManager;
import com.lchess.engine.board.Position;
import com.lchess.engine.board.Tile;
import com.lchess.engine.piece.model.PieceState;
import com.lchess.engine.piece.view.PieceColorEnum;
import com.lchess.engine.test.utils.TestUtils;

import java.util.HashMap;

/**
 * Created by liad on 01/09/2018.
 */
public class GameTest {
    private static BoardManager boardManager = BoardManager.getInstanse();

    private static Logger logger = new Logger();

    private static Boolean compareTileWithExpectation(Tile tile, HashMap<Position, PieceState> expectedInitBoardPositionMap){
        String methodName = "compareTileWithExpectation";
        Boolean tileIsOccupide = tile.getOccupide();
        PieceState tilePieceState = tile.getPieceState();
        Position tilePosition = tile.getPosition();

        PieceState expectedPieceState = expectedInitBoardPositionMap.get(tilePosition);
        if (tileIsOccupide == false){
            if (expectedPieceState == null){
                return true;
            }
            else{
                logger.errorMsg(methodName, "tile is not occupied but expected tile map holds piece state");
                return false;
            }
        }
        if (expectedPieceState == null){
            if (tilePieceState != null){
                logger.errorMsg(methodName, "tile is occupied but expected tile map does not holds piece state");
                return false;
            }
            else{
                return true;
            }
        }
        if (tilePieceState.equals(expectedPieceState)){
            return true;
        }
        else {
            logger.errorMsg(methodName, "tile and expected map holds different piece stats on the same position");
            return false;
        }
    }


    public static void getInitialTurnTest(){
        String methodName = "getInitialTurnTest";
        Game game = new GameImpl();
        game.startGame();
        PieceColorEnum currentTurn = game.getCurrentTurn();
        if (!currentTurn.equals(PieceColorEnum.WHITE)){
            logger.printTestFailed(methodName,"wrong turn");
        }
        else {
            logger.printTestPass(methodName);
        }
    }

    public static void getTurnOnLegalMoveTest(){
        String methodName = "getTurnOnLegalMoveTest";
        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('A', 2);
        Position destination = new Position('A', 3);
        game.movePiece(origin, destination);
        PieceColorEnum currentTurn = game.getCurrentTurn();
        if (!currentTurn.equals(PieceColorEnum.BLACK)){
            logger.printTestFailed(methodName,"wrong turn on legal move");
        }
        else {
            logger.printTestPass(methodName);
        }
    }

    public static void getTurnOnIllegalMoveTest(){
        String methodName = "getTurnOnIllegalMoveTest";
        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('A', 2);
        Position destination = new Position('A', 5);
        game.movePiece(origin, destination);
        PieceColorEnum currentTurn = game.getCurrentTurn();
        if (!currentTurn.equals(PieceColorEnum.WHITE)){
            logger.printTestFailed(methodName,"wrong turn on legal move");
        }
        else {
            logger.printTestPass(methodName);
        }
    }

    public static void moveBlackPawnOnWhitesTurnTest(){
        String methodName = "moveBlackPawnOnWhitesTurnTest";
        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('A', 7);
        Position destination = new Position('A', 6);
        game.movePiece(origin, destination);
        PieceColorEnum currentTurn = game.getCurrentTurn();
        if (!currentTurn.equals(PieceColorEnum.WHITE)){
            logger.printTestFailed(methodName,"Black moved in white's turn");
        }
        else {
            logger.printTestPass(methodName);
        }
    }

    public static void positionOfIllegalTurnMovePieceTest(){
        String methodName = "positionOfIllegalTurnMovePieceTest";

        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('A', 7);
        Position destination = new Position('A', 6);
        Position expectedDestination = new Position('A', 7);
        game.movePiece(origin, destination);
        HashMap<Position, PieceState> expectedBoardPositionMap = TestUtils.getExpectedInitBoardPositionsMap();
        TestUtils.setExpectedPosition(expectedBoardPositionMap, origin, expectedDestination);

        if (isBoardMetExpectaions(methodName, expectedBoardPositionMap)){
            logger.printTestPass(methodName);
        }
        else {
            logger.printTestFailed(methodName, "tile on board not as expected");
        }

    }

    public static void positionOfIllegalMovePieceTest(){
        String methodName = "positionOfIllegalMovePieceTest";

        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('A', 2);
        Position destination = new Position('B', 3);
        Position expectedDestination = new Position('A', 2);
        game.movePiece(origin, destination);
        HashMap<Position, PieceState> expectedBoardPositionMap = TestUtils.getExpectedInitBoardPositionsMap();
        TestUtils.setExpectedPosition(expectedBoardPositionMap, origin, expectedDestination);

        if (isBoardMetExpectaions(methodName, expectedBoardPositionMap)){
            logger.printTestPass(methodName);
        }
        else {
            logger.printTestFailed(methodName, "tile on board not as expected");
        }

    }

    private static Boolean isBoardMetExpectaions(String methodName, HashMap<Position, PieceState> expectedBoardPositionMap) {
        Board board = boardManager.getBoard();
        Tile[] tiles = board.getTiles();
        for (Tile tile : tiles) {
            if (compareTileWithExpectation(tile, expectedBoardPositionMap) == false) {
                return false;
            }
        }
        return true;
    }

    public static void startGameTest(){
        String methodName = "startGameTest";

        HashMap<Position,PieceState> initExpectedInitBoardPositionMap = TestUtils.getExpectedInitBoardPositionsMap();

        Game game = new GameImpl();
        game.startGame();

        if (isBoardMetExpectaions(methodName, initExpectedInitBoardPositionMap)){
            logger.printTestPass(methodName);
        }
        else {
            logger.printTestFailed(methodName, "tile on board not as expected");
        }

    }

    private static void tempMoveWhiteBishopTest() {
        String methodName = "tempMoveWhiteBishopTest";

        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('C', 1);
        Position destination = new Position('A', 3);
        Position expectedDestination = new Position('A', 3);
        game.movePiece(origin, destination);
        HashMap<Position, PieceState> expectedBoardPositionMap = TestUtils.getExpectedInitBoardPositionsMap();
        TestUtils.setExpectedPosition(expectedBoardPositionMap, origin, expectedDestination);

        if (isBoardMetExpectaions(methodName, expectedBoardPositionMap)){
            logger.printTestPass(methodName);
        }
        else {
            logger.printTestFailed(methodName, "tile on board not as expected");
        }
        printBoardDebug();
    }

    private static void tempMoveWhiteBishop1UpLeftTest() {
        String methodName = "tempMoveWhiteBishop1UpLeftTest";

        Game game = new GameImpl();
        game.startGame();
        Position origin = new Position('C', 1);
        Position destination = new Position('B', 2);
        Position expectedDestination = new Position('B', 2);
        game.movePiece(new Position('B', 2), new Position('B', 3));
        game.movePiece(new Position('B', 7), new Position('B', 5));
        game.movePiece(origin, destination);
        HashMap<Position, PieceState> expectedBoardPositionMap = TestUtils.getExpectedInitBoardPositionsMap();
        TestUtils.setExpectedPosition(expectedBoardPositionMap, origin, expectedDestination);

        if (isBoardMetExpectaions(methodName, expectedBoardPositionMap)){
            logger.printTestPass(methodName);
        }
        else {
            logger.printTestFailed(methodName, "tile on board not as expected");
        }
        printBoardDebug();
    }

    private static void printBoardDebug() {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.printBoard(boardManager.getBoard());
    }

    public static void main(String[] args){
        startGameTest();
        getInitialTurnTest();
        getTurnOnLegalMoveTest();
        getTurnOnIllegalMoveTest();
        moveBlackPawnOnWhitesTurnTest();
        positionOfIllegalTurnMovePieceTest();
        positionOfIllegalMovePieceTest();
        tempMoveWhiteBishopTest();
        tempMoveWhiteBishop1UpLeftTest();

    }
}
