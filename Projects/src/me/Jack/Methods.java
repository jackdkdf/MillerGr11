package me.Jack;

public class Methods {

    public static String padL(String string, int padding){
        return String.format("%1$" + padding + "s", string);
    }

    public static String padR(String string, int padding){
        return String.format("%1$-" + padding + "s", string);
    }

    public static void clearChat(int times){
        for(int i=times; i<5; i++){
            System.out.println();
        }
    }
}
