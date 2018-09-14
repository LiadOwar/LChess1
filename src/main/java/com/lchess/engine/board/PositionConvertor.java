package com.lchess.engine.board;

import com.lchess.UI.PieceMovementClient;

/**
 * Created by liad on 10/09/2018.
 */
public class PositionConvertor {
    public static Position convertClientPosition(String positionString){
        String[] split = positionString.split(",");
        String xPos = split[0];
        String yPos = split[1];
        Position ret = new Position(xPos.charAt(0), Integer.parseInt(yPos));
        return ret;
    }
}
