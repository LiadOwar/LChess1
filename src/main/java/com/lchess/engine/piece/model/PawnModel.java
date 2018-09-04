package com.lchess.engine.piece.model;

import com.lchess.engine.board.Position;
import com.lchess.engine.piece.model.pojo.PieceMovementInfo;
import com.lchess.engine.piece.model.pojo.PieceMovementPath;

/**
 * Created by liad on 31/08/2018.
 */
public class PawnModel extends PieceModel {

    @Override
    public PieceMovementInfo getPieceMovementInfo(Position origin, PieceState pawnState) {

        PieceMovementInfo ret = new PieceMovementInfo();
        if (!pawnState.getClass().getSimpleName().equals("PawnState")){
            System.out.println(String.format("Error: pawnMovementInfo was requested for [%s]",pawnState.getClass().getSimpleName()));
            return null;
        }
        ret = getPawnGeneralAllowableMoves(origin, (PawnState) pawnState);

        return ret;
    }

    private PieceMovementInfo getPawnGeneralAllowableMoves(Position origin, PawnState pawnState) {
        PieceMovementInfo ret = new PieceMovementInfo();
        PieceMovementPath path1 = new PieceMovementPath(origin);

        Position tempPosition = PieceMovmentUtils.moveForward(origin, pawnState.getColor(), 1);
        pathManager.tryAddPositionToPath(path1, tempPosition);
        ret.tryAddPath(path1);

        if(pawnState.getFirstMove()){
            PieceMovementPath path2 = new PieceMovementPath(origin);
            for (int i = 0 ; i < 2 ; i++){
                tempPosition = PieceMovmentUtils.moveForward(origin, pawnState.getColor(), i + 1);
                pathManager.tryAddPositionToPath(path2, tempPosition);
            }
            ret.tryAddPath(path2);
        }
        return ret;
    }
}
