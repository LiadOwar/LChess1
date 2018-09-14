package com.lchess.engine.board;

/**
 * Created by liad on 31/08/2018.
 */
public final class ChessCoordinate {
    private char xPos;
    private int yPos;

    public ChessCoordinate(char xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getyPos() {
        return yPos;
    }

    public char getxPos() {

        return xPos;
    }

    public ChessCoordinate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessCoordinate that = (ChessCoordinate) o;

        if (xPos != that.xPos) return false;
        return yPos == that.yPos;
    }

    @Override
    public int hashCode() {
        int result = (int) xPos;
        result = 31 * result + yPos;
        return result;
    }

    public void setXPos(char xPos) {
        this.xPos = xPos;
    }

    public void setYPos(Integer yPos) {
        this.yPos = yPos;
    }
}
