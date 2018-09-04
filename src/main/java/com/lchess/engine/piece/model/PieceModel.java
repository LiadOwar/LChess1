package com.lchess.engine.piece.model;

import com.lchess.engine.board.Position;
import com.lchess.engine.piece.model.pojo.PieceMovementInfo;

/**
 * Created by liad on 31/08/2018.
 */
public abstract class PieceModel {
    protected PathManager pathManager = new PathManagerImpl();

    public abstract PieceMovementInfo getPieceMovementInfo(Position origin, PieceState pieceState);
}
