package com.CHAPTER_SEVEN.TicTacToe;

import com.CHAPTER_SEVEN.TicTacToe.TicTacToeGameExceptionException.TicTacToeBoardOverFlowException;
import com.CHAPTER_SEVEN.TicTacToe.TicTacToeGameExceptionException.TicTacToeBoardUnderFlowException;


import java.util.Arrays;

import static com.CHAPTER_SEVEN.TicTacToe.TicTacToePlayers.*;


public class TicTacToeGame {
    private static final TicTacToePlayers[][] ticTacToeBoard =  {{EMPTY, EMPTY,EMPTY },
                                                            {EMPTY, EMPTY,EMPTY},
                                                            {EMPTY, EMPTY,EMPTY}};

    static TicTacToePlayers symbol = EMPTY;


    public static TicTacToePlayers[][] getTicTacToeBoard() {

        for (TicTacToePlayers[] board: ticTacToeBoard) {
            System.out.println ( Arrays.toString ( board ) );
        }
        return ticTacToeBoard;
    }


    public static TicTacToePlayers playGame(TicTacToePlayers player, int playerChoice) {
        setPlayer ( player );
        switch (playerChoice){
            case 1: if (ticTacToeBoard[0][0].equals (EMPTY))
                      return ticTacToeBoard[0][0] = symbol;
            case 2: if (ticTacToeBoard[0][1].equals (EMPTY))
                return ticTacToeBoard[0][1] = symbol;
            case 3: if (ticTacToeBoard[0][2].equals (EMPTY))
                return ticTacToeBoard[0][2] = symbol;
            case 4: if (ticTacToeBoard[1][0].equals (EMPTY))
                return ticTacToeBoard[1][0] = symbol;
            case 5: if (ticTacToeBoard[1][1].equals (EMPTY))
                return ticTacToeBoard[1][1] = symbol;
            case 6: if (ticTacToeBoard[1][2].equals (EMPTY))
                return ticTacToeBoard[1][2] = symbol;
            case 7: if (ticTacToeBoard[2][0].equals (EMPTY))
                return ticTacToeBoard[2][0] = symbol;
            case 8: if (ticTacToeBoard[2][1].equals (EMPTY))
                return ticTacToeBoard[2][1] = symbol;
            case 9: if (ticTacToeBoard[2][2].equals (EMPTY))
                return ticTacToeBoard[2][2] = symbol;
                break;
                default:
                    if (playerChoice < 1)
                throw new TicTacToeBoardUnderFlowException ( "position out of bound value: " + playerChoice );
                    else
                throw new TicTacToeBoardOverFlowException ("position out of bound value: " + playerChoice);
        }
        return PLAYED ;
    }
    public static void setPlayer(TicTacToePlayers player){
        if (player == X){ symbol = X; }
        else symbol = O;
    }

    public static TicTacToePlayers getWinner() {
        TicTacToePlayers winner = EMPTY;
        if (ticTacToeBoard[0][0].equals ( X ) && ticTacToeBoard[0][1].equals ( X ) && ticTacToeBoard[0][2].equals ( X ) ){
//            if (ticTacToeBoard[0][i++])
             winner = X;
             return winner;
        }

        if (ticTacToeBoard[1][0].equals ( X ) && ticTacToeBoard[1][1].equals ( X ) && ticTacToeBoard[1][2].equals ( X ) ){
            winner = X;
            return winner;}

        if (ticTacToeBoard[2][0].equals ( X ) && ticTacToeBoard[2][1].equals ( X ) && ticTacToeBoard[2][2].equals ( X ) ){
            winner = X;
            return winner;}
        if (ticTacToeBoard[0][0].equals ( O ) && ticTacToeBoard[0][1].equals ( O ) && ticTacToeBoard[0][2].equals ( O) ){
            winner = O;
            return winner;}

        if (ticTacToeBoard[1][0].equals ( O ) && ticTacToeBoard[1][1].equals ( O ) && ticTacToeBoard[1][2].equals ( O ) ){
            winner = O;
            return winner;}

        if (ticTacToeBoard[2][0].equals ( O ) && ticTacToeBoard[2][1].equals ( O ) && ticTacToeBoard[2][2].equals ( O ) ){
            winner = O;
            return winner;}

        return NO_WINNER;

    }

    @Override
    public String toString() {
        return (Arrays.toString ( ticTacToeBoard ));
    }
}

