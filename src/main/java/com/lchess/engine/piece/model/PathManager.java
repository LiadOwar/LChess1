package com.lchess.engine.piece.model;

import com.lchess.engine.board.Position;
import com.lchess.engine.piece.model.pojo.PieceMovementPath;

/**
 * Created by liad on 31/08/2018.
 */
public interface PathManager {
    Boolean tryAddPositionToPath(PieceMovementPath pieceMovementPath , Position position);
}
