package com.lchess.engine.piece.model.pojo;

import com.lchess.engine.board.Position;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by liad on 31/08/2018.
 */
public class PieceMovementPath {

    private ArrayList<Position> path = new ArrayList<>();

    public PieceMovementPath(Position position) {
        path.add(position);
    }

    public ArrayList<Position> getPath() {
        return path;
    }

    public void addPositionToPath(Position position){
        path.add(position);
    }

    public Position getPathLastPosition(PieceMovementPath pieceMovementPath){
        Position position = path.get(path.size() - 1);
        return position;
    }

    public Position getPathStartingPosition(PieceMovementPath pieceMovementPath){
        Position position = path.get(0);
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PieceMovementPath that = (PieceMovementPath) o;
        for (int i = 0; i < path.size(); i++){
            Position otherPosition = that.path.get(i);
            if (!otherPosition.equals(this.path.get(i))){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return path != null ? path.hashCode() : 0;
    }
}
