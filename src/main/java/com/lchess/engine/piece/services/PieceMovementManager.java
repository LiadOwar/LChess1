package com.lchess.engine.piece.services;

import com.lchess.engine.board.Position;
import com.lchess.engine.piece.model.pojo.PieceMovementPath;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by liad on 31/08/2018.
 */
public interface PieceMovementManager {
     PieceMovementPath findPathToDestination(HashSet<PieceMovementPath> allowedPaths, Position origin, Position destenation);

}
