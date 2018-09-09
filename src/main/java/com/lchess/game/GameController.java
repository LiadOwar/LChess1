package com.lchess.game;

import com.lchess.UI.ConsoleUI;
import com.lchess.engine.board.BoardManager;
import com.lchess.engine.board.Position;
import com.lchess.engine.board.Tile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liad on 05/09/2018.
 */
@RestController
public class GameController {

    @Autowired
    private ConsoleUI consoleUI;

    BoardManager boardManager = BoardManager.getInstanse();

    @CrossOrigin
    @RequestMapping("/game")
    public List getBoardTiles(){
        List<Tile> ret = consoleUI.getBoardTiles(boardManager.getBoard());
        return ret;
//        return consoleUI.representBoard(boardManager.getBoard());

    }
}
