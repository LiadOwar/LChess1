package com.lchess.engine.piece.model;

import com.lchess.engine.board.Position;
import com.lchess.engine.piece.model.pojo.PieceMovementInfo;
import com.lchess.engine.piece.model.pojo.PieceMovementPath;
import com.lchess.engine.piece.view.PieceTypeEnum;

/**
 * Created by liad on 01/09/2018.
 */
public class BishopModel extends PieceModel {
    @Override
    public PieceMovementInfo getPieceMovementInfo(Position origin, PieceState bishopState) {
        PieceMovementInfo ret = new PieceMovementInfo();
        if (!bishopState.getPieceType().equals(PieceTypeEnum.BISHOP)){
            System.out.println(String.format("Error: bishopMovementInfo was requested for [%s]",bishopState.getClass().getSimpleName()));
            return null;
        }
        ret = getBishopGeneralAllowableMoves(origin, (BishopState)bishopState);
        return ret;
    }

    private PieceMovementInfo getBishopGeneralAllowableMoves(Position origin, BishopState bishopState) {
        PieceMovementInfo ret = new PieceMovementInfo();
        generateDiagonalUpLeftPath(origin, bishopState, ret);
        return ret;
    }

    private void generateDiagonalUpLeftPath(Position origin, BishopState bishopState, PieceMovementInfo ret) {
        for (int i =0 ; i < 7; i++){
            PieceMovementPath tempPath = new PieceMovementPath(origin);
            char tempXpos = origin.getPosition().getxPos();
            int tempYpos = origin.getPosition().getyPos();
            Position currentPosition = new Position(tempXpos, tempYpos);

            for (int j = 0 ; j <= i ; j++){
                currentPosition  = PieceMovmentUtils.moveDiagonalUpLeft(currentPosition, bishopState.getColor(), 1);
                pathManager.tryAddPositionToPath(tempPath, currentPosition);
            }
            ret.tryAddPath(tempPath);
        }
    }

}
