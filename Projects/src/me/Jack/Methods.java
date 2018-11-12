package me.Jack;

import java.lang.reflect.Array;

public class Methods {

    public static String padL(String string, int padding){
        return String.format("%1$" + padding + "s", string);
    }

    public static String padR(String string, int padding){
        return String.format("%1$-" + padding + "s", string);
    }

    public static void clearChat(int times){
        for(int i=0; i<times; i++){
            System.out.println();
        }
    }

    public static int checkAmtLetters(String string, Character c){
        int count = 0;
            for(int i=0; i<string.length(); i++){
                if(string.toLowerCase().charAt(i) == c){
                    count++;
                }
            }

        return count;
    }

    public static void tally(int num, Character c){
        char capitalC = Character.toUpperCase(c);
        System.out.println();
        System.out.print(Methods.padR(capitalC + " (" + num + ")", 10));
        for(int i=0; i<num; i++){
            System.out.print("*");
        }
    }
}
