package com.lchess.UI;

import com.lchess.engine.board.Position;
import org.springframework.stereotype.Component;

/**
 * Created by liad on 10/09/2018.
 */

public class PieceMovementClient {
    private String startPosition;
    private String destPosition;

    public String getDestPosition() {
        return destPosition;
    }

    public void setDestPosition(String destPosition) {
        this.destPosition = destPosition;
    }

    public PieceMovementClient() {
    }

    public PieceMovementClient(String startPosition, String destPosition) {
        this.startPosition = startPosition;
        this.destPosition = destPosition;
    }

    public String getStartPosition() {

        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }


}
