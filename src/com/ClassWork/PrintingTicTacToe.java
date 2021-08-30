package com.ClassWork;


public class PrintingTicTacToe {

    public static void main(String[] args) {
        char[][] ticTacToe = {{'X', 'O', 'X'}, {'O',  'O', 'X'}, {'O',  'X',  'O'}};


        for (char[] row : ticTacToe) {
            for (char column:row) {
                System.out.print ( column + " | " );
            }
            System.out.println ();
        }



        }


        }





