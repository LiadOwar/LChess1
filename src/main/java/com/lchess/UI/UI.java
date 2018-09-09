package com.lchess.UI;

import com.lchess.engine.board.Board;
import org.springframework.stereotype.Component;

/**
 * Created by liad on 31/08/2018.
 */
@Component
public abstract class UI {
    public abstract void printBoard(Board board);
}
