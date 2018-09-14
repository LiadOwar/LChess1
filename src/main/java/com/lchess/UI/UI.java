package com.lchess.UI;

import com.lchess.engine.board.Board;
import com.lchess.engine.board.Tile;
import com.lchess.engine.piece.view.PieceColorEnum;
import com.lchess.game.Game;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liad on 31/08/2018.
 */

public abstract class UI {
    public abstract void printBoard(Board board);

    public abstract PieceColorEnum getTurn(Game game);
}
