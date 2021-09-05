package com.newpractice.chapter8;

public class Arrays {
    public static void main(String[] args) {

        var threeD = new int[3][4][5];
        for (var i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 5; k++){
                    threeD[i][j][k] = i * j * k;
                }
            }
        }

        for(var number : threeD){
            for(var num: number){
                for(var n: num){

                System.out.printf ( "%d ", n);}
                System.out.println ();
            }
            System.out.println ();

        }
////        for (int i = 0; i < 3; i++){
////            for (int j = 0; j < 4; j++){
////                for (int k = 0; k < 5; k++){
////                    System.out.print ( threeD[i][j][k] + " " );
////
////                }
////                System.out.println ();
////            }
////            System.out.println ();
//        }

    }


}
