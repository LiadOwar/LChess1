package com.lchess.engine.piece.view;

/**
 * Created by liad on 31/08/2018.
 */
public abstract class Piece {

    protected String pieceTypeName;

    protected PieceColorEnum color;


    public String getPieceTypeName() {
        return pieceTypeName;
    }

    public PieceColorEnum getColor() {

        return color;
    }
}
