package com.lchess.UI;

import com.lchess.engine.board.Board;
import com.lchess.engine.board.Tile;
import com.lchess.engine.piece.model.PieceState;
import com.lchess.engine.piece.view.PieceColorEnum;
import com.lchess.engine.piece.view.PieceTypeEnum;

/**
 * Created by liad on 31/08/2018.
 */
public class ConsoleUI extends UI {
    @Override
    public void printBoard(Board board) {
        Tile[] tiles = board.getTiles();
        System.out.println("********-Board-********");
        System.out.print("  ");
        for (int i = 0 ; i < 8; i++){
            System.out.print(String.format(" %c ",('A' + i)));
        }
        System.out.println("");
        for(Tile tile : tiles){
            if (tile.getPosition().getPosition().getxPos() == 'A'){
                System.out.print(String.format("%s ", tile.getPosition().getPosition().getyPos()));
            }
            printTile(tile);
            if (tile.getPosition().getPosition().getxPos() == 'H'){
                System.out.println(String.format(" %s", tile.getPosition().getPosition().getyPos()));
            }
        }
        System.out.print("  ");
        for (int i = 0 ; i < 8; i++){
            System.out.print(String.format(" %c ",('A' + i)));
        }
        System.out.println("");
    }

    private void printTile(Tile tile) {
        StringBuilder tileFormate = new StringBuilder();
        tileFormate.append("[");
        if (tile.getOccupide() == false){
            tileFormate.append(" ");
        }
        else {
            PieceState pieceState = tile.getPieceState();
            tileFormate.append(getPieceTypeStringRep(pieceState));
        }
        tileFormate.append("]");
        System.out.print(tileFormate);
    }

    private String getPieceTypeStringRep(PieceState pieceState){
        PieceTypeEnum typeName = pieceState.getPieceType();
        String ret = "";
        switch (typeName){
            case PAWN:
                if (pieceState.getColor().equals(PieceColorEnum.WHITE)){
                    ret = "P";
                }
                else {
                    ret = "p";
                }
                break;
            case BISHOP:
                if (pieceState.getColor().equals(PieceColorEnum.WHITE)){
                    ret = "B";
                } else {
                    ret = "b";
                }
        }
        return ret;
    }
}
