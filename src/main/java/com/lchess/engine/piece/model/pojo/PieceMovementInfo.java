package com.lchess.engine.piece.model.pojo;

import com.lchess.engine.board.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liad on 31/08/2018.
 */
public class PieceMovementInfo {

    private HashSet<PieceMovementPath> allowedPaths = new HashSet<>();

    public PieceMovementInfo() {

    }

    public HashSet<PieceMovementPath> getAllowedPaths() {
        return allowedPaths;
    }

    public  ArrayList<Position> getGeneralAllowableDestinations(){
        ArrayList<Position> ret = new ArrayList<>();
        for (PieceMovementPath pieceMovementPath : allowedPaths){
            ArrayList<Position> path = pieceMovementPath.getPath();
            Position destination = path.get(path.size() - 1);
            ret.add(destination);
        }
        return ret;
    }

    public void setAllowedPaths(HashSet<PieceMovementPath> allowedPaths) {
        this.allowedPaths = allowedPaths;
    }

    public void tryAddPath(PieceMovementPath path){
        if (path.getPath().size() > 1){
            allowedPaths.add(path);
            int a = 0;
        }
    }
}
