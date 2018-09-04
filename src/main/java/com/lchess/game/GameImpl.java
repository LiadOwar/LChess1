package com.lchess.game;

import com.lchess.engine.board.Board;
import com.lchess.engine.board.BoardManager;
import com.lchess.engine.board.Position;
import com.lchess.engine.board.Tile;
import com.lchess.engine.piece.model.PieceState;
import com.lchess.engine.piece.view.PieceColorEnum;

/**
 * Created by liad on 01/09/2018.
 */
public class GameImpl implements Game {
    private static Board board;
    private static BoardManager boardManager;
    private PieceColorEnum turn;
    @Override
    public void startGame() {
        boardManager = BoardManager.getInstanse();
        boardManager.resetBoard();
        board = boardManager.getBoard();

        turn = PieceColorEnum.WHITE;
    }

    @Override
    public void movePiece(Position origin, Position destination) {
        if (checkTurn(origin) == false){
            return;
        }
        Boolean isCompleted = boardManager.tryMovePieceOnTheBoard(origin, destination);
        if (isCompleted){
            nextTurn();
        }
    }

    private boolean checkTurn(Position origin) {
        Tile tileFromPosition = boardManager.getTileFromPosition(board, origin);
        PieceState pieceState = tileFromPosition.getPieceState();
        PieceColorEnum color = pieceState.getColor();
        if (!color.equals(turn)){
            return false;
        }
        return true;
    }

    @Override
    public PieceColorEnum getCurrentTurn() {
        return turn;
    }

    private void nextTurn(){
        if (turn.equals(PieceColorEnum.WHITE)){
            turn = PieceColorEnum.BLACK;
        }
        else if (turn.equals(PieceColorEnum.BLACK)){
            turn = PieceColorEnum.WHITE;
        }
    }
}
