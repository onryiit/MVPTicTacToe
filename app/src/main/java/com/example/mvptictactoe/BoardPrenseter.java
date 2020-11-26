package com.example.mvptictactoe;

import android.view.View;

public class BoardPrenseter  implements  BoardListener{
    BoardView view;
    Board board;
    public BoardPrenseter(BoardView boardView) {
        view = boardView;
        board = new Board(this);
    }
    public void move(byte row,byte col){
        board.move(row,col);
    }

    static public class CellClickListener implements View.OnClickListener {
        BoardPrenseter prenseter;
        byte row;
        byte col;

        public CellClickListener(BoardPrenseter prenseter, byte row, byte col) {
        this.prenseter = prenseter;
        this.row = row ;
        this.col = col;
        }

        @Override
        public void onClick(View v) {
        prenseter.move(row,col);
        }
    }
    public void playedAt(byte player,byte row,byte col){
    if(player == BoardListener.PLAYER_1){
        view.putSymbol(BoardView.PLAYER_1_SYMBOL,row,col);
    }else if (player == BoardListener.PLAYER_2){
        view.putSymbol(BoardView.PLAYER_2_SYMBOL,row,col);
    }

    }

    public void gameEnded(byte winner){
    switch (winner){
        case BoardListener.NO_ONE:
            view.gameEnded(BoardView.DRAW);
            break;
        case BoardListener.PLAYER_1:
            view.gameEnded(BoardView.PLAYER_1_WINNER);
            break;
        case BoardListener.PLAYER_2:
            view.gameEnded(BoardView.PLAYER_2_WINNER);
    }
    }

    @Override
    public void invalidPlay(byte row, byte col) {
        view.invalidPlay(row,col);
    }
}
