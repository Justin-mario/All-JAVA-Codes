package com.Kata;

import java.util.EmptyStackException;
import java.util.Stack;


public class WorkingWithStack {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        stack.push ( 12.90 );
        stack.push ( 34 );
        stack.push ( 45L );
        stack.push ( 89F );
        stack.pop ();
        for (int i = 0; i < 11; i++) {
                stack.push ( i );
        }
        System.out.println (stack + " ");
        System.out.println (stack.peek ());
        try{
            Number removeObject;
            while (true){
                removeObject = stack.pop ();
                System.out.printf ("%s ", removeObject);
                if (stack.size () == 1){
                    break;
                }
            }
        }
        catch (EmptyStackException emptyStackException){
            emptyStackException.printStackTrace ();
        }
        System.out.println ("\n" + stack + " ");
    }

}
