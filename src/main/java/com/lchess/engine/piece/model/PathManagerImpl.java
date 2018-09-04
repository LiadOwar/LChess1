package com.lchess.engine.piece.model;

import com.lchess.engine.board.*;
import com.lchess.engine.piece.model.pojo.PieceMovementPath;

/**
 * Created by liad on 31/08/2018.
 */
public class PathManagerImpl implements PathManager {
    private static BoardManager boardManager = BoardManager.getInstanse();
    private static Board board;

    public PathManagerImpl() {
        board = boardManager.getBoard();
    }

    @Override
    public void tryAddPositionToPath(PieceMovementPath pieceMovementPath, Position position) {
        if (BoardUtils.isOutOfBoard(position)) {
            return;

        }
        if (boardManager.checkIfCanMoveToPosition(pieceMovementPath, position)) {
            pieceMovementPath.addPositionToPath(position);
        }

    }
}




