package com.lchess.engine.test;

import com.lchess.UI.ConsoleUI;
import com.lchess.UI.UI;
import com.lchess.engine.board.Board;
import com.lchess.engine.board.BoardManager;
import com.lchess.engine.board.ChessCoordinate;
import com.lchess.engine.board.Position;
import com.lchess.engine.piece.model.PawnState;
import com.lchess.engine.piece.model.PieceState;
import com.lchess.engine.piece.view.PieceColorEnum;

/**
 * Created by liad on 31/08/2018.
// */
//public class consoleUITest {
//    private static BoardManager boardManager = BoardManager.getInstanse();
//    private static UI ui = new ConsoleUI();
//
//    public static void main(String[] args){
//        Board board = boardManager.getBoard();
//        PieceState pawn = new PawnState(PieceColorEnum.WHITE);
//        Position position = new Position(new ChessCoordinate('A', 2));
//        boardManager.setPieceOnBoard(pawn, position, board);
//
//        ui.printBoard(board);
//
//    }
//}
